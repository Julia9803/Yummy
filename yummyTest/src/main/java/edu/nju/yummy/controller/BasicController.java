package edu.nju.yummy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {
    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("/userLogin")
    public String login() {
        return "userLogin.jsp";
    }

    @RequestMapping("/userSignup")
    public String signUp() { return "userSignup.jsp"; }

    @RequestMapping("/useredit")
    public String userEdit() {
        return "useredit.jsp";
    }

    @RequestMapping("/userOrder")
    public String userOrder() {
        return "userOrder.jsp";
    }

    @RequestMapping("/userMakeOrder")
    public String userMakeOrder() {
        return "userMakeOrder.jsp";
    }

    @RequestMapping("/restaurantLogin")
    public String resLogin() {
        return "restaurantLogin.jsp";
    }

    @RequestMapping("/restaurantSignup")
    public String resSignup() {
        return "restaurantSignup.jsp";
    }

    @RequestMapping("/restaurantEdit")
    public String resEdit() {
        return "restaurantEdit.jsp";
    }

    @RequestMapping("/test")
    public String test() {
        return "test.jsp";
    }
}
