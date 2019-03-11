package edu.nju.yummy.dao;

import edu.nju.yummy.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired UserRepository repository;
    User user = new User();
    String phoneNumber = "13811111111";

    @Test
    public void save() {
        user.setPhoneNumber(phoneNumber);
        repository.save(user);
        Assert.assertNotNull(repository.findAll());
    }

    @Test
    public void find() {
        Assert.assertNotNull(repository.findAll());
    }

    @Test
    public void findByPhoneNumber() {
        User user = repository.findByPhoneNumber(phoneNumber);
        System.out.println(user.getPhoneNumber());
        Assert.assertNotNull(repository.findByPhoneNumber(phoneNumber));
    }

    @Test
    public void findAll() {
        System.out.println(repository.findAll());
        Assert.assertNotEquals(null, repository.findAll());
//        repository.delete(user);
    }
}