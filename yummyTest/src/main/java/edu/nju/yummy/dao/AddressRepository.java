package edu.nju.yummy.dao;

import edu.nju.yummy.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer> {
    Address findById(int id);
    ArrayList<Address> findByCode(String code);
    // for user
    Address findByCodeAndChosenTrue(String code);
    Address save(Address address);
    void deleteById(int id);
}
