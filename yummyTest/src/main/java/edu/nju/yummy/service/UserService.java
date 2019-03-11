package edu.nju.yummy.service;

import edu.nju.yummy.entity.Address;
import edu.nju.yummy.model.Message;
import edu.nju.yummy.entity.User;

import java.util.ArrayList;

public interface UserService {
    Message register(User user);
    Message changeName(String email, String name);
    Message changeAddress(String email, Address address);
    Message addAddress(String email, Address address);
    Message cancel(String email);
    Message changePassword(String email, String password);
    Message changeBankAccount(String email, String bankAccount);
    Message login(String email, String password);
    Message delAddress(String email, int aid);
    User findByPhoneNumber(String email);
    User findByEmail(String email);
    ArrayList<Address> findAddressByEmail(String email);
    Message setAllNotChosen(String email);
}
