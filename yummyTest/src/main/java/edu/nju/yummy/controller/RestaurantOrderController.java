package edu.nju.yummy.controller;

import edu.nju.yummy.entity.Restaurant;
import edu.nju.yummy.model.HistoryOrderPresent;
import edu.nju.yummy.service.impl.ResStatServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class RestaurantOrderController {
    @Autowired
    ResStatServiceBean resStatServiceBean;

    @RequestMapping("/restaurantOrder")
    public String getResOrder(HttpServletRequest req, HttpSession session) {
        Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");
        String type = req.getParameter("type");
        ArrayList<HistoryOrderPresent> presents = resStatServiceBean.checkResDeliverRecords(restaurant.getIdCode(),type);
        session.setAttribute("presents",presents);
        session.setAttribute("restaurant",restaurant);
        return "restaurantOrder.jsp";
    }
}
