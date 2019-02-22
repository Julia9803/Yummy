package edu.nju.yummy.dao;

import edu.nju.yummy.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User save(User user);
    User findByPhoneNumber(String phoneNumber);
    ArrayList<User> findAll();
    void delete(User user);
}
