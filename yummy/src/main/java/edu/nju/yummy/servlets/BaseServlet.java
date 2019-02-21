package edu.nju.yummy.servlets;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class BaseServlet {
    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response) {
        return "/index";
    }
}
