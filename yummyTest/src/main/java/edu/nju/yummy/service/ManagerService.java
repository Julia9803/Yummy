package edu.nju.yummy.service;

import edu.nju.yummy.model.*;

import java.util.ArrayList;

public interface ManagerService {
    Message register(String username, String password);
    Message login(String username,String password);
    ArrayList<ResCheck> getResChange();
    Message checkResOK(String idCode);
    Message checkResFail(String idCode);
    RestaurantStatistics getResStat();
    UserStatistics getUserStat();
    CompanyFinance getCompanyFinanceStat();
    ResChart getResChart();
    UserChart getUserChart();
    CompanyChart getCompanyChart();
}