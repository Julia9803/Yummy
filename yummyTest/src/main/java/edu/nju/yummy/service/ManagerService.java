package edu.nju.yummy.service;

import edu.nju.yummy.model.*;

import java.util.ArrayList;

public interface ManagerService {
    ArrayList<Restaurant> getResChange();
    Message checkResChange(int rid,boolean res);
    RestaurantStatistics getResStat();
    UserStatistics getUserStat();
    CompanyFinance getCompanyFinanceStat();
}