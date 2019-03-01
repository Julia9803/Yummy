package edu.nju.yummy.util;

import org.apache.commons.mail.EmailException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmailManagerTest {
    @Autowired
    EmailManager manager;

    @Test
    public void sendEmail() throws EmailException {
        String code = manager.sendEmail("925583000@qq.com");
        System.out.println(code);
    }
}