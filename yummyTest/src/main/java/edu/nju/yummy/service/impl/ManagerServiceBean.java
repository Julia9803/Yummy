package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.CompanyRepository;
import edu.nju.yummy.dao.OrderRepository;
import edu.nju.yummy.dao.RestaurantRepository;
import edu.nju.yummy.dao.UserRepository;
import edu.nju.yummy.model.*;
import edu.nju.yummy.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ManagerServiceBean implements ManagerService {

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public ArrayList<Restaurant> getResChange() {
        return restaurantRepository.findByCheckedFalse();
    }

    @Override
    public Message checkResChange(int rid, boolean res) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(rid);
        restaurant.setChecked(res);
        restaurantRepository.save(restaurant);
        if(!res) {
            return Message.FAIL;
        }
        return Message.SUCCESS;
    }

    @Override
    public RestaurantStatistics getResStat() {
        int resNum = (int) restaurantRepository.count();
        int orderNum = (int) orderRepository.count();
        double averageOrderNum = orderNum/resNum;

        ArrayList<OrderForm> cancelledForms = orderRepository.findAllByCancelledTrueOrderByRestaurantId();
        int cancelNum = cancelledForms.size();
        double averageCancelRate = cancelNum/resNum;

        ArrayList<Restaurant> restaurants = restaurantRepository.findAll();

        /**
         * rid orderNum
         */
        HashMap<Integer,Integer> resOrders = new HashMap<>();
        /**
         * rid cancelledNum
         */
        HashMap<Integer,Double> resCancelledRate = new HashMap<>();
        for(Restaurant restaurant:restaurants) {
            int rid = restaurant.getRestaurantId();
            int resOrderNum = (int) orderRepository.countByRestaurantId(rid);
            resOrders.put(rid,resOrderNum);

            int resCancelledNum = (int) orderRepository.countByRestaurantIdAndCancelledTrue(rid);
            resCancelledRate.put(rid,(double) resCancelledNum/resOrderNum);
        }

        return new RestaurantStatistics(resNum,averageOrderNum,averageCancelRate,resCancelledRate,resOrders);
    }

    @Override
    public UserStatistics getUserStat() {
        int userNum = (int) userRepository.count();
        int orderNum = (int) orderRepository.count();
        double averageOrderNum = orderNum/userNum;

        ArrayList<OrderForm> payedForms = orderRepository.findAllByPayedTrueOrderByUserPhone();
        int payedNum = payedForms.size();
        double averagePayedNum = payedNum/userNum;

        ArrayList<User> users = userRepository.findAll();
        /**
         * uid orderNum
         */
        HashMap<String,Integer> userOrders = new HashMap<>();
        /**
         * uid paidRate
         */
        HashMap<String,Double> userPayedRate = new HashMap<>();
        for(User user:users) {
            String phoneNumber = user.getPhoneNumber();
            int userOrderNum = (int) orderRepository.countByUserPhone(phoneNumber);
            userOrders.put(phoneNumber,userOrderNum);

            int userPayedNum = (int) orderRepository.countByUserPhoneAndPayedTrue(phoneNumber);
            userPayedRate.put(phoneNumber,(double) userPayedNum/userOrderNum);
        }

        /**
         * grade number
         */
        HashMap<Integer,Integer> gradeNumber = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            gradeNumber.put(i, (int) userRepository.countByGrade(i));
        }

        return new UserStatistics(userNum,averageOrderNum,averagePayedNum,userPayedRate,gradeNumber,userOrders);
    }

    @Override
    public CompanyFinance getCompanyFinanceStat() {
        /**
         * income
         */
        double income = 0.00;
        ArrayList<Company> companies = companyRepository.findAll();
        for(Company company:companies) {
            income += company.getIncome();
        }

        /**
         * rid income
         */
        HashMap<Integer,Double> ridIncome = new HashMap<>();
        ArrayList<Restaurant> restaurants = restaurantRepository.findAll();
        for (Restaurant restaurant:restaurants) {
            int rid = restaurant.getRestaurantId();
            Company company = companyRepository.findByRid(rid);
            if(company != null) {
                ridIncome.put(rid, company.getIncome());
            } else {
                ridIncome.put(rid, 0.00);
            }
        }

        /**
         * uid payment
         */
        HashMap<String,Double> uidPayment = new HashMap<>();
        ArrayList<User> users = userRepository.findAll();
        for(User user:users) {
            uidPayment.put(user.getPhoneNumber(),user.getTotalSpend());
        }

        /**
         * month income
         */
//        HashMap<String, Double> monthlyIncome = new HashMap<>();

        return new CompanyFinance(income,ridIncome,uidPayment);
    }
}
