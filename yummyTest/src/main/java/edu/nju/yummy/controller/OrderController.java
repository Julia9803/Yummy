package edu.nju.yummy.controller;

import edu.nju.yummy.dao.*;
import edu.nju.yummy.entity.Bank;
import edu.nju.yummy.entity.OrderForm;
import edu.nju.yummy.entity.Restaurant;
import edu.nju.yummy.entity.User;
import edu.nju.yummy.model.*;
import edu.nju.yummy.service.impl.UserOrderServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@RestController
public class OrderController {
    @Autowired
    UserOrderServiceBean userOrderServiceBean;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BankRepository bankRepository;

    @RequestMapping("/userMakeOrder/addBag")
    public String addBag(HttpServletRequest req, HttpSession session) {
        ArrayList<BagContent> bagContents = null;
        if(session.getAttribute("bag") != null) {
            bagContents = (ArrayList<BagContent>) session.getAttribute("bag");
        } else {
            bagContents = new ArrayList<>();
        }
        String idCode = req.getParameter("idCode");
        int foodId = Integer.parseInt(req.getParameter("foodId"));
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        int orderNum = Integer.parseInt(req.getParameter("orderNum"));
        double price = Double.parseDouble(req.getParameter("price"));

        User user = (User) session.getAttribute("user");
        String userPhone = user.getPhoneNumber();

        BagContent bagContent = new BagContent(idCode,foodId,name,type,orderNum,price,userPhone);
        bagContents.add(bagContent);

        session.setAttribute("bag",bagContents);
        session.setAttribute("user",user);
        return "SUCCESS";
    }

    @RequestMapping("/order")
    public String order(HttpServletRequest req, HttpSession session) {
        double orderMoney = Double.parseDouble(req.getParameter("orderMoney"));
        double discount = Double.parseDouble(req.getParameter("discount"));
        double totalMoney = Double.parseDouble(req.getParameter("totalMoney"));

        ArrayList<BagContent> bagContents = (ArrayList<BagContent>) session.getAttribute("bag");
        User user = userRepository.findByPhoneNumber(bagContents.get(0).getUserPhone());
        Restaurant restaurant = restaurantRepository.findByIdCode(bagContents.get(0).getIdCode());
        OrderForm form = new OrderForm();
        form.setDelivering(false);
        form.setEnsureDelivered(false);
        form.setDelivered(false);
        form.setCancelled(false);
        form.setPayed(false);
        form.setTime(new Date());
        form.setRestaurantIdCode(restaurant.getIdCode());
        form.setUserPhone(user.getPhoneNumber());
        form.setUserAddressId(addressRepository.findByCodeAndChosenTrue(user.getEmail()).getId());
        form.setOrderMoney(orderMoney);
        form.setDiscount(discount);
        form.setTotalMoney(totalMoney);

        userOrderServiceBean.orderMeal(form,bagContents);
        session.setAttribute("bag",null);
        return "SUCCESS";
    }

    @RequestMapping("/restaurantOrder/deliver")
    public String deliver(HttpServletRequest req, HttpSession session) {
        int oid = Integer.parseInt(req.getParameter("oid"));
        OrderForm form = orderRepository.findByOrderId(oid);
        form.setDelivering(true);
        form.setDelivered(false);
        orderRepository.save(form);
        return "SUCCESS";
    }

    @RequestMapping("/restaurantOrder/delivered")
    public String delivered(HttpServletRequest req) {
        int oid = Integer.parseInt(req.getParameter("oid"));
        OrderForm form = orderRepository.findByOrderId(oid);
        form.setDelivering(false);
        form.setDelivered(true);
        form.setEnsureDelivered(true);
        orderRepository.save(form);
        return "SUCCESS";
    }

    @RequestMapping("/userOrder/cancel")
    public String cancel(HttpServletRequest req,HttpSession session) {
        int oid = Integer.parseInt(req.getParameter("oid"));
        User user = (User) session.getAttribute("user");
        HashMap<Message,Double> res = userOrderServiceBean.cancelMeal(oid,user.getBankAccount());
        if(res.containsKey(Message.SUCCESS)) {
            return "退款成功！退款金额： "+res.get(Message.SUCCESS);
        } else if(res.containsKey(Message.DELIVERING)) {
            return "正在配送中... 退款金额："+res.get(Message.DELIVERING);
        } else if(res.containsKey(Message.DELIVERED)) {
            return "已配送... 退款金额： "+res.get(Message.DELIVERED);
        } else if(res.containsKey(Message.OVERTIME)) {
            return "超时 退款金额： "+res.get(Message.OVERTIME);
        }
        return "SUCCESS";
    }

    @RequestMapping("/userOrder/ensure")
    public String ensureDelivered(HttpServletRequest req) {
        int oid = Integer.parseInt(req.getParameter("oid"));
        OrderForm form = orderRepository.findByOrderId(oid);
        form.setEnsureDelivered(true);
        orderRepository.save(form);
        return "SUCCESS";
    }
}
