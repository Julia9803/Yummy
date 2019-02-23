package edu.nju.yummy.controller;

import edu.nju.yummy.model.Address;
import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.OrderForm;
import edu.nju.yummy.model.User;
import edu.nju.yummy.service.impl.UserServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class UserController {
    @Autowired
    UserServiceBean userServiceBean;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String userSignUp(HttpServletRequest req, HttpSession session) {
        String phoneNumber = req.getParameter("phoneNumber");
        User user = userServiceBean.findByPhoneNumber(phoneNumber);
        if(user == null) {
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            ArrayList<Address> addresses = new ArrayList<>();
            addresses.add((Address)session.getAttribute("address"));
            String email = req.getParameter("email");
            boolean isCancelled = false;
            int grade = 1;
            ArrayList<OrderForm> orderForms = new ArrayList<>();

            User user1 = new User();
            user1.setPassword(password);
            user1.setCancelled(isCancelled);
            user1.setAddresses(addresses);
            user1.setName(name);
            user1.setEmail(email);
            user1.setGrade(grade);
            user1.setPhoneNumber(phoneNumber);
            user1.setOrderForms(orderForms);
            userServiceBean.register(user1);

            return "index";
        } else {
            session.setAttribute("res","抱歉，该手机号码已注册！");
            return "login";
        }
    }


    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String userLogin(HttpServletRequest req, HttpSession session) {
        String phoneNumber = req.getParameter("phoneNumber");
        String password = req.getParameter("password");
        Message message = userServiceBean.login(phoneNumber,password);
        String res = null;

        if(message.equals(Message.NOTFOUND)) {
            res = "抱歉，此电话号码未注册！";
            session.setAttribute("res",res);
        } else if(message.equals(Message.FAIL)) {
            res = "抱歉，用户名或密码错误！";
            session.setAttribute("res",res);
        }else if(message.equals(Message.SUCCESS)) {
            User user = userServiceBean.findByPhoneNumber(phoneNumber);
            session.setAttribute("user",user);
            return "index";
        }
        return "login";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public void updateUser(HttpServletRequest req,HttpSession session) {
        String phoneNumber = req.getParameter("phoneNumber");
        String name = req.getParameter("name");
        ArrayList<Address> addresses = (ArrayList<Address>)session.getAttribute("addresses");
        String isCancel = req.getParameter("isCancel"); // 0 1
        String password = req.getParameter("password");

        if(name != null) {
            userServiceBean.changeName(phoneNumber,name);
        }

        if(addresses.size() != 0) {
            userServiceBean.changeAddress(phoneNumber,addresses);
        }

        if(isCancel.equals("1")) {
            userServiceBean.cancel(phoneNumber);
        }

        if(password != null) {
            userServiceBean.changePassword(phoneNumber,password);
        }
    }
}
