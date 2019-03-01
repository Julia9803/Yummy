package edu.nju.yummy.service.impl;

import edu.nju.yummy.dao.AddressRepository;
import edu.nju.yummy.dao.UserRepository;
import edu.nju.yummy.model.Address;
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
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Message register(User user) {
        if(userRepository.findByPhoneNumber(user.getPhoneNumber()) == null) {
            userRepository.save(user);
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    @Override
    public Message changeName(String email, String name) {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            user.setName(name);
            userRepository.save(user);
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    @Override
    public Message changeAddress(String email, Address address) {
        User user = userRepository.findByEmail(email);
        if(user != null) {
            Address address1 = addressRepository.findById(address.getId());
            address1.setProvince(address.getProvince());
            address1.setCity(address.getCity());
            address1.setDistrict(address.getDistrict());
            address1.setDetail(address.getDetail());
            address1.setCode(email);
            addressRepository.save(address1);
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    @Override
    public Message addAddress(String email, Address address) {
        if(address != null) {
            addressRepository.save(address);
            return Message.SUCCESS;
        }
        return Message.FAIL;
    }

    @Override
    public Message cancel(String email) {
        User user = userRepository.findByEmail(email);
        user.setCancelled(true);
        userRepository.save(user);
        return Message.SUCCESS;
    }

    @Override
    public Message changePassword(String email, String password) {
        User user = userRepository.findByEmail(email);
        user.setPassword(password);
        return Message.SUCCESS;
    }

    @Override
    public Message login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user != null && user.getPassword().equals(password)) {
            return Message.SUCCESS;
        } else if(user == null) {
            return Message.NOTFOUND;
        }
        return Message.FAIL;
    }

    @Override
    public Message delAddress(String email, int aid) {
        Address address = addressRepository.findById(aid);
        if(address != null) {
            addressRepository.deleteById(aid);
            return Message.SUCCESS;
        }
        return Message.NOTFOUND;
    }

    @Override
    public User findByPhoneNumber(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null || user.isCancelled()) {
            return null;
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null || user.isCancelled()) {
            return null;
        }
        return user;
    }

    @Override
    public ArrayList<Address> findAddressByEmail(String email) {
        return addressRepository.findByCode(email);
    }


}
