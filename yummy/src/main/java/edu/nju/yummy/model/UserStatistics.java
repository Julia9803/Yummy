package edu.nju.yummy.model;

import java.util.HashMap;

public class UserStatistics {
    private int userNumber;
    /**
     * uid grade
     */
    private HashMap<Integer,Integer> uidGrade;
    /**
     * uid paidRate
     */
    private HashMap<Integer,Double> paiedRate;
    /**
     * grade userNumber
     */
    private HashMap<Integer,Integer> gradeNumber;
}
