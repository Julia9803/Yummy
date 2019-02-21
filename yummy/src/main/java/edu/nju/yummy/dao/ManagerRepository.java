package edu.nju.yummy.dao;

import edu.nju.yummy.model.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager,Integer> {
    Manager save(Manager manager);
    Manager findByManagerId(int id);
}
