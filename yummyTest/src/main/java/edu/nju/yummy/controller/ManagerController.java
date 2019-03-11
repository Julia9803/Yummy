package edu.nju.yummy.controller;

import edu.nju.yummy.model.*;
import edu.nju.yummy.service.impl.ManagerServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ManagerController {
    @Autowired
    ManagerServiceBean managerServiceBean;

    @RequestMapping(value = "/manager",method = RequestMethod.POST)
    public String register(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Message message = managerServiceBean.register(username,password);
        if(message.equals(Message.SUCCESS)) {
            return "index.jsp";
        } else {
            return "managerSignup.jsp";
        }
    }

    @RequestMapping(value = "/manager",method = RequestMethod.GET)
    public String login(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Message message = managerServiceBean.login(username,password);
        if(message.equals(Message.SUCCESS)) {
            return "managerIndex.jsp";
        } else {
            return "managerLogin.jsp";
        }
    }

    @RequestMapping("/managerCheckRes")
    public String managerCheckRes(HttpSession session) {
        session.setAttribute("resChecks",managerServiceBean.getResChange());
        return "managerCheckRes.jsp";
    }

    @RequestMapping(value = "/checkOK",method = RequestMethod.POST)
    public String checkOK(HttpServletRequest req, HttpSession session) {
        String idCode = req.getParameter("idCode");
        managerServiceBean.checkResOK(idCode);
        session.setAttribute("checkProcess","已审核通过");
        return "managerCheckRes.jsp";
    }

    @RequestMapping(value = "/checkFail",method = RequestMethod.POST)
    public String checkFail(HttpServletRequest req, HttpSession session) {
        String idCode = req.getParameter("idCode");
        managerServiceBean.checkResFail(idCode);
        session.setAttribute("checkProcess","未审核通过");
        return "managerCheckRes.jsp";
    }

    @RequestMapping(value = "/managerStat")
    public String getStat(HttpSession session) {
        RestaurantStatistics restaurantStatistics = managerServiceBean.getResStat();
        UserStatistics userStatistics = managerServiceBean.getUserStat();
        CompanyFinance companyFinance = managerServiceBean.getCompanyFinanceStat();
        session.setAttribute("resStat",restaurantStatistics);
        session.setAttribute("userStat",userStatistics);
        session.setAttribute("companyStat",companyFinance);
        return "managerStat.jsp";
    }

    @RequestMapping(value = "/managerStat/res", method = RequestMethod.GET)
    @ResponseBody
    public ResChart getResChart() {
        return managerServiceBean.getResChart();
    }

    @RequestMapping(value = "/managerStat/user", method = RequestMethod.GET)
    @ResponseBody
    public UserChart getUserChart() {
        return managerServiceBean.getUserChart();
    }

    @RequestMapping(value = "/managerStat/company", method = RequestMethod.GET)
    @ResponseBody
    public CompanyChart getCompanyChart() {
        return managerServiceBean.getCompanyChart();
    }
}
