package edu.nju.yummy.service;

import edu.nju.yummy.model.CompanyFinance;
import edu.nju.yummy.model.RestaurantStatistics;
import edu.nju.yummy.model.UserStatistics;

public interface ManagerStatisticsService {
    RestaurantStatistics checkResStat();
    UserStatistics checkUserStat();
    CompanyFinance checkCompanyFinanceStat();
}
