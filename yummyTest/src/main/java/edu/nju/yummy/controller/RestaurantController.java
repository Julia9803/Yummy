package edu.nju.yummy.controller;

import edu.nju.yummy.dao.AddressRepository;
import edu.nju.yummy.dao.FoodRepository;
import edu.nju.yummy.entity.Address;
import edu.nju.yummy.entity.ComboFood;
import edu.nju.yummy.entity.Food;
import edu.nju.yummy.entity.Restaurant;
import edu.nju.yummy.model.*;
import edu.nju.yummy.service.impl.RestaurantServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class RestaurantController {
    @Autowired
    RestaurantServiceBean restaurantServiceBean;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    FoodRepository foodRepository;

    @RequestMapping(value = "/restaurantE",method = RequestMethod.POST)
    public String updateRestaurant(HttpServletRequest req, HttpSession session) {
        String idCode = req.getParameter("idCode");
        String phoneNumber = req.getParameter("phoneNumber");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        Address address = new Address();
        address.setCode(idCode);
        address.setProvince(req.getParameter("province"));
        address.setCity(req.getParameter("city"));
        address.setDistrict(req.getParameter("district"));
        address.setDetail(req.getParameter("detail"));
        restaurantServiceBean.update(idCode,phoneNumber,name,password,type,address);

        session.setAttribute("checkProcess","正在审核中");
        return "restaurantEdit.jsp";
    }

    @RequestMapping(value = "/restaurant",method = RequestMethod.POST)
    public String restaurantSignUp(HttpServletRequest req, HttpSession session) {
        String idCode = req.getParameter("code");
        Restaurant restaurant = restaurantServiceBean.findByIdCode(idCode);
        if(restaurant == null) {
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            String type = req.getParameter("type");
            String phoneNumber = req.getParameter("phoneNumber");

            Restaurant restaurant1 = new Restaurant();
            restaurant1.setPassword(password);
            restaurant1.setChangeType(type);
//            restaurant1.setType(type);
            restaurant1.setChangeName(name);
//            restaurant1.setName(name);
            restaurant1.setPhoneNumber(phoneNumber);
            restaurant1.setIdCode(idCode);
            restaurantServiceBean.register(restaurant1);

            String province = req.getParameter("province");
            String city = req.getParameter("city");
            String district = req.getParameter("district");
            String detail = req.getParameter("detail");

            Address address = new Address();
            address.setCode(idCode);
            address.setChangeProvince(province);
            address.setChangeCity(city);
            address.setChangeDistrict(district);
            address.setChangeDetail(detail);
//            address.setProvince(province);
//            address.setCity(city);
//            address.setDistrict(district);
//            address.setDetail(detail);
            restaurantServiceBean.updateAddress(address);

            return "index.jsp";
        } else {
            session.setAttribute("res","抱歉，该手机号码已注册！");
            return "restaurantLogin.jsp";
        }
    }

    @RequestMapping(value = "/restaurant",method = RequestMethod.GET)
    public String restaurantLogin(HttpServletRequest req, HttpSession session) {
        String idCode = req.getParameter("code");
        String password = req.getParameter("password");
        Message message = restaurantServiceBean.login(idCode,password);
        String res = null;

        if(message.equals(Message.NOTFOUND)) {
            res = "抱歉，此编号未注册！";
            session.setAttribute("res",res);
        } else if(message.equals(Message.FAIL)) {
            res = "抱歉，编号或密码错误！";
            session.setAttribute("res",res);
        }else if(message.equals(Message.SUCCESS)) {
            Restaurant restaurant = restaurantServiceBean.findByIdCode(idCode);
            ArrayList<Address> addresses = restaurantServiceBean.findAddressByIdCode(idCode);
            session.setAttribute("restaurant",restaurant);
            session.setAttribute("address",addresses.get(0));
            return "restaurantIndex.jsp";
        }
        return "restaurantLogin.jsp";
    }

    @RequestMapping(value = "/resCode",method = RequestMethod.GET)
    @ResponseBody
    public String generateResId(ModelAndView model, HttpSession session) {
        return String.valueOf(Math.random()*10000000).substring(0,7);
    }

    @RequestMapping(value = "/publishSingle",method = RequestMethod.POST)
    public String publishSingle(HttpServletRequest req,HttpSession session) {
        String idCode = req.getParameter("idCode");
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        double price = Double.parseDouble(req.getParameter("price"));
        int totalNum = Integer.parseInt(req.getParameter("totalNum"));
        Date startTime = transfer(req.getParameter("startTime"));
        Date endTime = transfer(req.getParameter("endTime"));

        Food food = new Food();
        food.setName(name);
        food.setPrice(price);
        food.setType(type);
        food.setStartTime(startTime);
        food.setEndTime(endTime);
        food.setNum(totalNum);
        food.setRestaurantId(idCode);
        restaurantServiceBean.publishSingle(idCode,food);

        Restaurant restaurant = restaurantServiceBean.findByIdCode(idCode);
        session.setAttribute("restaurant",restaurant);
        return "restaurantPublish.jsp";
    }

    @RequestMapping(value = "/publishCombo",method = RequestMethod.POST)
    public String publishCombo(HttpServletRequest req, HttpSession session) {
        ComboFood food = new ComboFood();
        String idCode = req.getParameter("idCode");
        int num = Integer.parseInt(req.getParameter("num"));
        String name = null;
        for (int i = 0; i < num; i++) {
            if(i == 0)
                name = req.getParameter("name"+i);
            else
                name = name+"和"+req.getParameter("name"+i);
        }
        double price = Double.parseDouble(req.getParameter("price"));
        int totalNum = Integer.parseInt(req.getParameter("totalNum"));

        Date startTime = transfer(req.getParameter("startTime"));
        Date endTime = transfer(req.getParameter("endTime"));

        food.setPrice(price);
        food.setName(name);
        food.setRestaurantIdCode(idCode);
        food.setStartTime(startTime);
        food.setEndTime(endTime);
        food.setNum(totalNum);
        restaurantServiceBean.publishCombo(idCode,food);

        Restaurant restaurant = restaurantServiceBean.findByIdCode(idCode);
        session.setAttribute("restaurant",restaurant);
        return "restaurantPublish.jsp";
    }

    public Date transfer(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
