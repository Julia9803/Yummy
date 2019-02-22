package edu.nju.yummy.service;

import edu.nju.yummy.model.Message;
import edu.nju.yummy.model.User;

import java.util.ArrayList;

public interface UserService {
    Message register(User user);
    Message changeName(String phoneNumber, String name);
    Message changeAddress(String phoneNumber, ArrayList<String> addresses);
    Message cancel(String phoneNumber);
    Message changePassword(String phoneNumber, String password);
    Message login(String phoneNumber, String password);
    User findByPhoneNumber(String phoneNumber);
}
