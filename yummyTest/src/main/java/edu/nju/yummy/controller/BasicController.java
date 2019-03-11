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

    @RequestMapping(value = "/restaurantPublish")
    public String publishInfo() {
        return "restaurantPublish.jsp";
    }

    @RequestMapping("/managerLogin")
    public String managerLogin() {
        return "managerLogin.jsp";
    }

    @RequestMapping("/managerSignup")
    public String managerSignup() {
        return "managerSignup.jsp";
    }

    @RequestMapping("/test")
    public String test() {
        return "test.jsp";
    }
}
