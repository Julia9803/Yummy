package edu.nju.yummy.service.impl;

import edu.nju.yummy.model.RestaurantPresent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserOrderServiceBeanTest {
    @Autowired UserOrderServiceBean userOrderServiceBean;

    @Test
    public void getResPresent() {
        ArrayList<RestaurantPresent> presents = userOrderServiceBean.getResPresent("julia925583000@gmail.com");
        System.out.println(presents.size());
        System.out.println(presents.get(1).getFoodNames().toString());
    }
}