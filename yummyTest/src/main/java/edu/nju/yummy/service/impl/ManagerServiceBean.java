package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.*;
import edu.nju.yummy.entity.*;
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
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Message register(String username, String password) {
        Manager manager = new Manager();
        manager.setUsername(username);
        manager.setPassword(password);
        managerRepository.save(manager);
        return Message.SUCCESS;
    }

    @Override
    public Message login(String username, String password) {
        Manager manager = managerRepository.findByUsername(username);
        String password1 = manager.getPassword();
        if(password.equals(password1)) {
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    @Override
    public ArrayList<ResCheck> getResChange() {
        ArrayList<ResCheck> resChecks = new ArrayList<>();
        ResCheck resCheck = new ResCheck();
        ArrayList<Restaurant> restaurants = restaurantRepository.findByCheckedFalse();
        if(restaurants == null) {
            return null;
        }

        for(Restaurant restaurant:restaurants) {
            resCheck.setIdCode(restaurant.getIdCode());
            if(restaurant.getChangeName() != null)
                resCheck.setName(restaurant.getChangeName());
            else
                resCheck.setName(restaurant.getName());
            if(restaurant.getChangeType() != null)
                resCheck.setType(restaurant.getChangeType());
            else
                resCheck.setType(restaurant.getType());
            ArrayList<Address> addresses = addressRepository.findByCode(restaurant.getIdCode());
            Address address = null;
            if(addresses.size() == 0)
                return null;
            else
                address = addresses.get(0);
            resCheck.setAddress(address);
            resChecks.add(resCheck);
        }
        return resChecks;
    }

    @Override
    public Message checkResOK(String idCode) {
        Restaurant restaurant = restaurantRepository.findByIdCode(idCode);
        restaurant.setChecked(true);
        if(restaurant.getChangeName() != null)
            restaurant.setName(restaurant.getChangeName());
        restaurant.setChangeName(null);
        if(restaurant.getChangeType() != null)
            restaurant.setType(restaurant.getChangeType());
        restaurant.setChangeType(null);
        restaurantRepository.save(restaurant);
        Address address = addressRepository.findByCode(idCode).get(0);
        if(address.getChangeProvince() != null)
            address.setProvince(address.getChangeProvince());
        address.setChangeProvince(null);
        if(address.getChangeCity() != null)
        address.setCity(address.getChangeCity());
        address.setChangeCity(null);
        if(address.getChangeDistrict() != null)
            address.setDistrict(address.getChangeDistrict());
        address.setChangeDistrict(null);
        if(address.getChangeDetail() != null)
            address.setDetail(address.getChangeDetail());
        address.setChangeDetail(null);
        addressRepository.save(address);
        return Message.SUCCESS;
    }

    @Override
    public Message checkResFail(String idCode) {
        Restaurant restaurant = restaurantRepository.findByIdCode(idCode);
        restaurant.setChecked(true);
        restaurant.setChangeName(null);
        restaurant.setChangeType(null);
        restaurantRepository.save(restaurant);
        Address address = addressRepository.findByCode(idCode).get(0);
        address.setChangeProvince(null);
        address.setChangeCity(null);
        address.setChangeDistrict(null);
        address.setChangeDetail(null);
        addressRepository.save(address);
        return Message.SUCCESS;
    }

    @Override
    public RestaurantStatistics getResStat() {
        int resNum = (int) restaurantRepository.count();
        int orderNum = (int) orderRepository.count();
        double averageOrderNum = orderNum/resNum;

        ArrayList<OrderForm> cancelledForms = orderRepository.findAllByCancelledTrueOrderByRestaurantIdCode();
        int cancelNum = cancelledForms.size();
        double averageCancelRate = cancelNum/resNum;

        ArrayList<Restaurant> restaurants = restaurantRepository.findAll();

        /**
         * idCode orderNum
         */
        HashMap<String,Integer> resOrders = new HashMap<>();
        /**
         * idCode cancelledNum
         */
        HashMap<String,Double> resCancelledRate = new HashMap<>();
        for(Restaurant restaurant:restaurants) {
            String idCode = restaurant.getIdCode();
            int resOrderNum = (int) orderRepository.countByRestaurantIdCode(idCode);
            resOrders.put(idCode,resOrderNum);

            int resCancelledNum = (int) orderRepository.countByRestaurantIdCodeAndCancelledTrue(idCode);
            if(resOrderNum == 0)
                resCancelledRate.put(idCode,0.0);
            else
                resCancelledRate.put(idCode,(double) resCancelledNum/resOrderNum);
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
            String email = userRepository.findByPhoneNumber(phoneNumber).getEmail();
            userOrders.put(email,userOrderNum);

            int userPayedNum = (int) orderRepository.countByUserPhoneAndPayedTrue(phoneNumber);
            userPayedRate.put(email,(double) userPayedNum/userOrderNum);
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
        HashMap<String,Double> ridIncome = new HashMap<>();
        ArrayList<Restaurant> restaurants = restaurantRepository.findAll();
        for (Restaurant restaurant:restaurants) {
            String idCode = restaurant.getIdCode();
            ArrayList<Company> company = companyRepository.findByRidCode(idCode);
            double income1 = 0;
            if(company != null) {
                for(Company company1:company) {
                    income1 += company1.getIncome();
                }
                ridIncome.put(idCode, income1);
            } else {
                ridIncome.put(idCode, 0.00);
            }
        }

        /**
         * uid payment
         */
        HashMap<String,Double> uidPayment = new HashMap<>();
        ArrayList<User> users = userRepository.findAll();
        for(User user:users) {
            uidPayment.put(user.getEmail(),user.getTotalSpend());
        }

        /**
         * month income
         */
//        HashMap<String, Double> monthlyIncome = new HashMap<>();

        return new CompanyFinance(income,ridIncome,uidPayment);
    }

    @Override
    public ResChart getResChart() {
        RestaurantStatistics restaurantStatistics = getResStat();
        ArrayList<String> idCodes = new ArrayList<>();
        ArrayList<Double> cancelRate = new ArrayList<>();
        ArrayList<Integer> orderNumber = new ArrayList<>();
        for(String idCode:restaurantStatistics.getCancelRate().keySet()) {
            idCodes.add(idCode);
            cancelRate.add(restaurantStatistics.getCancelRate().get(idCode));
            orderNumber.add(restaurantStatistics.getOrderNumber().get(idCode));
        }
        return new ResChart(idCodes,cancelRate,orderNumber);
    }

    @Override
    public UserChart getUserChart() {
        UserStatistics userStatistics = getUserStat();
        ArrayList<String> uid = new ArrayList<>();
        ArrayList<Double> paidRate = new ArrayList<>();
        ArrayList<Integer> grades = new ArrayList<>();
        ArrayList<Integer> userNumber = new ArrayList<>();
        ArrayList<Integer> orderNumber = new ArrayList<>();
        for(String email:userStatistics.getPaidRate().keySet()) {
            uid.add(email);
            paidRate.add(userStatistics.getPaidRate().get(email));
            orderNumber.add(userStatistics.getOrderNumber().get(email));
        }
        for(Integer grade:userStatistics.getGradeNumber().keySet()) {
            grades.add(grade);
            userNumber.add(userStatistics.getGradeNumber().get(grade));
        }
        return new UserChart(uid,paidRate,grades,userNumber,orderNumber);
    }

    @Override
    public CompanyChart getCompanyChart() {
        CompanyFinance companyFinance = getCompanyFinanceStat();
        ArrayList<String> rid = new ArrayList<>();
        ArrayList<Double> income = new ArrayList<>();
        ArrayList<String> uid = new ArrayList<>();
        ArrayList<Double> payment = new ArrayList<>();
        for(String email:companyFinance.getUidPayment().keySet()) {
            uid.add(email);
            payment.add(companyFinance.getUidPayment().get(email));
        }
        for(String ridCode:companyFinance.getRidIncome().keySet()) {
            rid.add(ridCode);
            income.add(companyFinance.getRidIncome().get(ridCode));
        }
        return new CompanyChart(rid,income,uid,payment);
    }
}
