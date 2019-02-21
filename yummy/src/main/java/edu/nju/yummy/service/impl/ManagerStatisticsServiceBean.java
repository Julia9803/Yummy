package edu.nju.yummy.service.impl;

import edu.nju.yummy.model.CompanyFinance;
import edu.nju.yummy.model.RestaurantStatistics;
import edu.nju.yummy.model.UserStatistics;
import edu.nju.yummy.service.ManagerStatisticsService;
import org.springframework.stereotype.Service;

@Service
public class ManagerStatisticsServiceBean implements ManagerStatisticsService {
    @Override
    public RestaurantStatistics checkResStat() {
        return null;
    }

    @Override
    public UserStatistics checkUserStat() {
        return null;
    }

    @Override
    public CompanyFinance checkCompanyFinanceStat() {
        return null;
    }
}
