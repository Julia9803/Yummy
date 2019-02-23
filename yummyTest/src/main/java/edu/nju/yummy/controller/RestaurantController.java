package edu.nju.yummy.controller;

import edu.nju.yummy.model.*;
import edu.nju.yummy.service.impl.RestaurantServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class RestaurantController {
    @Autowired
    RestaurantServiceBean restaurantServiceBean;

    @RequestMapping(value = "/restaurant",method = RequestMethod.OPTIONS)
    public void publishInfo(HttpServletRequest req, HttpSession session) {
        int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
        SingleFoodPack singleFoodPack = (SingleFoodPack) session.getAttribute("singleFoodPack");
        ComboFoodPack comboFoodPack = (ComboFoodPack) session.getAttribute("comboFoodPack");
        restaurantServiceBean.publishSingle(restaurantId,singleFoodPack);
        restaurantServiceBean.publishCombo(restaurantId,comboFoodPack);
    }

    @RequestMapping(value = "/restaurant",method = RequestMethod.PUT)
    public void updateRestaurant(HttpServletRequest req, HttpSession session) {
        int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
        String phoneNumber = req.getParameter("phoneNumber");
        String name = req.getParameter("name");
        Address address = (Address) session.getAttribute("address");
        String password = req.getParameter("password");
        String type = req.getParameter("type");


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
        String phoneNumber = req.getParameter("phoneNumber");
        Restaurant restaurant = restaurantServiceBean.findByPhoneNumber(phoneNumber);
        if(restaurant == null) {
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            Address address = (Address)session.getAttribute("address");
            String type = req.getParameter("type");
            ArrayList<OrderForm> orderForms = new ArrayList<>();
            ArrayList<SingleFoodPack> singleFoodPacks = new ArrayList<>();
            ArrayList<ComboFoodPack> comboFoodPacks = new ArrayList<>();

            Restaurant restaurant1 = new Restaurant();
            restaurant1.setPassword(password);
            restaurant1.setType(type);
            restaurant1.setAddress(address);
            restaurant1.setName(name);
            restaurant1.setSingleFoodPacks(singleFoodPacks);
            restaurant1.setComboFoodPacks(comboFoodPacks);
            restaurant1.setPhoneNumber(phoneNumber);
            restaurant1.setOrderForms(orderForms);
            restaurantServiceBean.register(restaurant1);

            return "index";
        } else {
            session.setAttribute("res","抱歉，该手机号码已注册！");
            return "login";
        }
    }

    @RequestMapping(value = "/restaurant",method = RequestMethod.GET)
    public String restaurantLogin(HttpServletRequest req, HttpSession session) {
        int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
        String password = req.getParameter("password");
        Message message = restaurantServiceBean.login(restaurantId,password);
        String res = null;

        if(message.equals(Message.NOTFOUND)) {
            res = "抱歉，此编号未注册！";
            session.setAttribute("res",res);
        } else if(message.equals(Message.FAIL)) {
            res = "抱歉，编号或密码错误！";
            session.setAttribute("res",res);
        }else if(message.equals(Message.SUCCESS)) {
            Restaurant restaurant = restaurantServiceBean.findById(restaurantId);
            session.setAttribute("restaurant",restaurant);
            return "index";
        }
        return "login";
    }

}
