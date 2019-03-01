package edu.nju.yummy.controller;

import edu.nju.yummy.dao.AddressRepository;
import edu.nju.yummy.model.*;
import edu.nju.yummy.service.impl.RestaurantServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RestaurantController {
    @Autowired
    RestaurantServiceBean restaurantServiceBean;
    @Autowired
    AddressRepository addressRepository;

    @RequestMapping(value = "/restaurant",method = RequestMethod.OPTIONS)
    public void publishInfo(HttpServletRequest req, HttpSession session) {
        String idCode = req.getParameter("idCode");
        Food singleFood = (Food) session.getAttribute("singleFoodPack");
        ComboFood comboFood = (ComboFood) session.getAttribute("comboFoodPack");
        int singleNum = (int) session.getAttribute("singleNum");
        int combeNum = (int) session.getAttribute("comboNum");
        restaurantServiceBean.publishSingle(idCode,singleFood, singleNum);
        restaurantServiceBean.publishCombo(idCode,comboFood, combeNum);
    }

    @RequestMapping(value = "/restaurant",method = RequestMethod.PUT)
    public void updateRestaurant(HttpServletRequest req, HttpSession session) {
        String idCode = req.getParameter("idCode");
        String phoneNumber = req.getParameter("phoneNumber");
        String name = req.getParameter("name");
        Address address = (Address) session.getAttribute("address");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        restaurantServiceBean.update(idCode,phoneNumber,name,password,type);


//        if(name != null) {
//            restaurantServiceBean.changeName(restaurantId,name);
//        }
//
//        if(address != null) {
//            restaurantServiceBean.changeAddress(restaurantId,address);
//        }
//
//        if(password != null) {
//            restaurantServiceBean.changePassword(restaurantId,password);
//        }
//
//        if(phoneNumber != null) {
//            restaurantServiceBean.changePhone(restaurantId,phoneNumber);
//        }
//
//        if(type != null) {
//            restaurantServiceBean.changeType(restaurantId,type);
//        }
//
//        if(singleFoodPack != null) {
//            restaurantServiceBean.publishSingle(restaurantId,singleFoodPack);
//        }
//
//        if(comboFoodPack != null) {
//            restaurantServiceBean.publishCombo(restaurantId,comboFoodPack);
//        }
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
            restaurant1.setType(type);
            restaurant1.setName(name);
            restaurant1.setPhoneNumber(phoneNumber);
            restaurant1.setIdCode(idCode);
            restaurantServiceBean.register(restaurant1);

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
            session.setAttribute("restaurant",restaurant);
            return "index.jsp";
        }
        return "restaurantLogin.jsp";
    }

    @RequestMapping(value = "/resCode",method = RequestMethod.GET)
    public String generateResId(ModelAndView model, HttpSession session) {
        String resCode = String.valueOf(Math.random()*10000000).substring(0,7);
        session.setAttribute("resCode",resCode);
        model.addObject("resCode",resCode);
        return "restaurantSignup.jsp";
    }

    @RequestMapping(value = "/resAddress",method = RequestMethod.POST)
    public String setResAddress(HttpServletRequest req, HttpSession session) {
        String idCode = req.getParameter("code");
        String province = req.getParameter("province");
        String city = req.getParameter("city");
        String district = req.getParameter("district");
        String detail = req.getParameter("detail");

        Address address = new Address();
        address.setCode(idCode);
        address.setProvince(province);
        address.setCity(city);
        address.setDistrict(district);
        address.setDetail(detail);
        addressRepository.save(address);
        session.setAttribute("address",address);
        return "restaurantSignup.jsp";
    }

}
