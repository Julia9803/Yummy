package edu.nju.yummy.controller;

import edu.nju.yummy.dao.BankRepository;
import edu.nju.yummy.dao.OrderRepository;
import edu.nju.yummy.entity.Bank;
import edu.nju.yummy.entity.OrderForm;
import edu.nju.yummy.model.BagContent;
import edu.nju.yummy.model.HistoryOrderPresent;
import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.RestaurantPresent;
import edu.nju.yummy.entity.User;
import edu.nju.yummy.service.impl.UserOrderServiceBean;
import edu.nju.yummy.service.impl.UserStatServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class UserOrderController {
    @Autowired
    UserOrderServiceBean userOrderServiceBean;
    @Autowired
    UserStatServiceBean userStatServiceBean;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BankRepository bankRepository;

    @RequestMapping("/userMakeOrder")
    public String userMakeOrder(HttpServletRequest req, HttpSession session) {
        User user = (User) session.getAttribute("user");
        ArrayList<RestaurantPresent> presents = userOrderServiceBean.getResPresent(user.getEmail());
        session.setAttribute("presents",presents);
        session.setAttribute("user",user);
        return "userMakeOrder.jsp";
    }

    @RequestMapping("/userOrder")
    public String userOrder(HttpSession session) {
        ArrayList<BagContent> contents = (ArrayList<BagContent>) session.getAttribute("bag");
        User user = (User) session.getAttribute("user");
        double orderMoney = userOrderServiceBean.calOrderMoney(contents);
        double discount = userOrderServiceBean.getDiscount(user.getGrade(),orderMoney);
        session.setAttribute("orderMoney",orderMoney);
        session.setAttribute("discount",discount);
        session.setAttribute("user",user);
        session.setAttribute("bag",contents);
        return "userOrder.jsp";
    }

    @RequestMapping("/userHistoryOrder")
    public String userHistoryOrder(HttpServletRequest req, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String type = req.getParameter("type");
        ArrayList<HistoryOrderPresent> orderPresent = userOrderServiceBean.checkUserOrderInfo(user.getPhoneNumber(),type);
        session.setAttribute("orderPresent",orderPresent);
        session.setAttribute("user",user);
        return "userHistoryOrder.jsp";
    }

    @RequestMapping("/userPay")
    public String pay(HttpServletRequest req, HttpSession session) {
        int oid = Integer.parseInt(req.getParameter("oid"));

        OrderForm form = orderRepository.findByOrderId(oid);
        session.setAttribute("oid",oid);
        session.setAttribute("money",form.getTotalMoney());
        session.setAttribute("user",session.getAttribute("user"));
        return "userPay.jsp";
    }

    @RequestMapping(value = "/bank",method = RequestMethod.GET)
    public String bank(ModelAndView view, HttpServletRequest req, HttpSession session) {
        session.setAttribute("user",session.getAttribute("user"));
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        int oid = (int) session.getAttribute("oid");
        Message message = userOrderServiceBean.payMeal(account,password,oid);
        if(message.equals(Message.SUCCESS)) {
            return "/userHistoryOrder";
        } else if(message.equals(Message.NOTFOUND)) {
            session.setAttribute("res","账号不存在");
            session.setAttribute("money",session.getAttribute("money"));
            return "/userPay?oid="+session.getAttribute("oid");
        } else if(message.equals(Message.BALANCELOW)) {
            session.setAttribute("res","余额不足");
            session.setAttribute("money",session.getAttribute("money"));
            return "/userPay?oid="+session.getAttribute("oid");
        } else if(message.equals(Message.FAIL)) {
            session.setAttribute("res","账号或密码错误");
            session.setAttribute("money",session.getAttribute("money"));
            return "/userPay?oid="+session.getAttribute("oid");
        }
        return "/userHistoryOrder";
    }

}
