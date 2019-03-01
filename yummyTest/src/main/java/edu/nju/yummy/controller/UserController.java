package edu.nju.yummy.controller;

import edu.nju.yummy.model.Address;
import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.User;
import edu.nju.yummy.service.impl.UserServiceBean;
import edu.nju.yummy.util.EmailManager;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class UserController {
    @Autowired
    UserServiceBean userServiceBean;
    @Autowired
    EmailManager manager;
    String code = null;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String userSignUp(@RequestParam("phoneNumber") String phoneNumber, @RequestParam("password") String password
            , @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("code") String code,
                             HttpServletRequest req, HttpSession session) {
        User user = userServiceBean.findByPhoneNumber(phoneNumber);
        if(user == null) {

            User user1 = new User();
            user1.setPassword(password);
            user1.setCancelled(false);
            user1.setName(name);
            user1.setEmail(email);
            user1.setGrade(0);
            user1.setPhoneNumber(phoneNumber);
            userServiceBean.register(user1);

            return "index.jsp";
        } else {
            session.setAttribute("res","抱歉，该邮箱已注册！");
            return "userSignup.jsp";
        }
    }


    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String userLogin(HttpServletRequest req, HttpSession session) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Message message = userServiceBean.login(email,password);
        String res = null;

        if(message.equals(Message.NOTFOUND)) {
            res = "抱歉，此电话号码未注册！";
            session.setAttribute("res",res);
        } else if(message.equals(Message.FAIL)) {
            res = "抱歉，用户名或密码错误！";
            session.setAttribute("res",res);
        }else if(message.equals(Message.SUCCESS)) {
            User user = userServiceBean.findByEmail(email);
            ArrayList<Address> addresses = userServiceBean.findAddressByEmail(email);
            session.setAttribute("user",user);
            session.setAttribute("addresses",addresses);
            return "userIndex.jsp";
        }
        return "userLogin.jsp";
    }

    @RequestMapping(value = "/userE",method = RequestMethod.POST)
    public String updateUser(HttpServletRequest req,HttpSession session) {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String isCancel = req.getParameter("cancel"); // Y N
        String password = req.getParameter("password");

        if(name != null) {
            userServiceBean.changeName(email,name);
        }

        if(isCancel.equals("Y")) {
            userServiceBean.cancel(email);
        }

        if(password != null) {
            userServiceBean.changePassword(email,password);
        }

        User user = userServiceBean.findByEmail(email);
        ArrayList<Address> addresses = userServiceBean.findAddressByEmail(email);
        session.setAttribute("user",user);
        session.setAttribute("addresses",addresses);
        return "useredit.jsp";
    }

    @RequestMapping(value = "/userEA",method = RequestMethod.POST)
    public String changeAddress(HttpServletRequest req,HttpSession session) {
        String email = req.getParameter("email");
        int id = Integer.parseInt(req.getParameter("id"));
        String province = req.getParameter("province");
        String city = req.getParameter("city");
        String district = req.getParameter("district");
        String detail = req.getParameter("detail");

        Address address = new Address();
        address.setId(id);
        address.setProvince(province);
        address.setCity(city);
        address.setDistrict(district);
        address.setDetail(detail);
        address.setCode(email);
        userServiceBean.changeAddress(email,address);

        User user = userServiceBean.findByEmail(email);
        ArrayList<Address> addresses = userServiceBean.findAddressByEmail(email);
        session.setAttribute("user",user);
        session.setAttribute("addresses",addresses);
        return "useredit.jsp";
    }

    @RequestMapping(value = "/userDA",method = RequestMethod.POST)
    public String delAddress(HttpServletRequest req,HttpSession session) {
        String email = req.getParameter("email");
        int id = Integer.parseInt(req.getParameter("id"));
        userServiceBean.delAddress(email,id);

        User user = userServiceBean.findByEmail(email);
        ArrayList<Address> addresses = userServiceBean.findAddressByEmail(email);
        session.setAttribute("user",user);
        session.setAttribute("addresses",addresses);
        return "useredit.jsp";
    }

    @RequestMapping(value = "/userA",method = RequestMethod.POST)
    public String addAddress(HttpServletRequest req,HttpSession session) {
        String email = req.getParameter("emailA");
        String province = req.getParameter("provinceA");
        String city = req.getParameter("cityA");
        String district = req.getParameter("districtA");
        String detail = req.getParameter("detailA");

        Address address = new Address();
        address.setProvince(province);
        address.setCity(city);
        address.setDistrict(district);
        address.setDetail(detail);
        address.setCode(email);
        userServiceBean.addAddress(email,address);

        User user = userServiceBean.findByEmail(email);
        ArrayList<Address> addresses = userServiceBean.findAddressByEmail(email);
        session.setAttribute("user",user);
        session.setAttribute("addresses",addresses);

        return "useredit.jsp";
    }

    @RequestMapping("/email")
    @ResponseBody
    public String sendEmail(HttpServletRequest req, HttpSession session) throws EmailException {
        String email = req.getParameter("email");
        code = manager.sendEmail(email);
        System.out.println(code);
        session.setAttribute("code",code);
        return null;
    }
}
