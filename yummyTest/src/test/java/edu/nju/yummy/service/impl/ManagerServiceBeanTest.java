package edu.nju.yummy.service.impl;

import edu.nju.yummy.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ManagerServiceBeanTest {
    @Autowired
    ManagerServiceBean managerServiceBean;

    @Test
    public void getResChange() {
        ArrayList<ResCheck>  resChecks = managerServiceBean.getResChange();
        System.out.println(resChecks.size());
        for (ResCheck resCheck:resChecks) {
            System.out.println(resCheck.getIdCode());
        }
    }

    @Test
    public void getResStat() {
        RestaurantStatistics restaurantStatistics = managerServiceBean.getResStat();
        assertNotNull(restaurantStatistics);
        System.out.println(restaurantStatistics.getResNum());
        System.out.println(restaurantStatistics.getAverageCancelRate());
        System.out.println(restaurantStatistics.getAverageOrderNum());
        System.out.println(restaurantStatistics.getCancelRate());
        System.out.println(restaurantStatistics.getOrderNumber());
    }

    @Test
    public void getUserStat() {
        UserStatistics userStatistics = managerServiceBean.getUserStat();
        assertNotNull(userStatistics);
        System.out.println(userStatistics.getUserNum());
        System.out.println(userStatistics.getAverageOrderNum());
        System.out.println(userStatistics.getAveragePayedNum());
        System.out.println(userStatistics.getGradeNumber());
        System.out.println(userStatistics.getOrderNumber());
        System.out.println(userStatistics.getPaidRate());
    }

    @Test
    public void getCompanyFinanceStat() {
        CompanyFinance companyFinance = managerServiceBean.getCompanyFinanceStat();
        assertNotNull(companyFinance);
        System.out.println(companyFinance.getRidIncome());
        System.out.println(companyFinance.getTotalIncome());
        System.out.println(companyFinance.getUidPayment());
    }

    @Test
    public void getUserChart() {
        UserChart userChart = managerServiceBean.getUserChart();
        assertNotNull(userChart);
        System.out.println(userChart.getGrade());
        System.out.println(userChart.getUserNumber());
    }
}