package edu.nju.yummy.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RestaurantControllerTest {
    @Autowired
    RestaurantController controller;

    @Test
    public void transfer() {
        Date date = controller.transfer("2019-03-05");
        System.out.println(date);
    }
}