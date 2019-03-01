package edu.nju.yummy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userOrder")
public class OrderController {
    @RequestMapping("/")
    public String orderPage() {
        return "userOrder";
    }
}
