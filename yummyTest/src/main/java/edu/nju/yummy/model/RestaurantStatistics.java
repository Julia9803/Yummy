package edu.nju.yummy.model;

import java.util.HashMap;

public class RestaurantStatistics {
    private int restaurants;
    /**
     * rid deliveredRate
     */
    private HashMap<Integer,Double> deliveredRate;
    /**
     * rid orderNumber
     */
    private HashMap<Integer,Integer> orderNumber;
}
