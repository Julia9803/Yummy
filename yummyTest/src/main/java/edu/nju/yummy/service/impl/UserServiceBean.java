package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.UserRepository;
import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.User;
import edu.nju.yummy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceBean implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Message register(User user) {
        if(userRepository.findByPhoneNumber(user.getPhoneNumber()) == null) {
            userRepository.save(user);
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    @Override
    public Message changeName(String phoneNumber, String name) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if(user != null) {
            user.setName(name);
            userRepository.save(user);
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    @Override
    public Message changeAddress(String phoneNumber, ArrayList<String> addresses) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if(user != null) {
            user.setAddresses(addresses);
            userRepository.save(user);
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    @Override
    public Message cancel(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        user.setCancelled(true);
        userRepository.save(user);
        return Message.SUCCESS;
    }

    @Override
    public Message changePassword(String phoneNumber, String password) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        user.setPassword(password);
        return Message.SUCCESS;
    }

    @Override
    public Message login(String phoneNumber, String password) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if(user != null && user.getPassword().equals(password)) {
            return Message.SUCCESS;
        } else if(user == null) {
            return Message.NOTFOUND;
        }
        return Message.FAIL;
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if(user.isCancelled()) {
            return null;
        }
        return user;
    }
}
