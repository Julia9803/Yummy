package edu.nju.yummy.dao;

import edu.nju.yummy.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Integer> {
    ArrayList<Company> findByRidCode(String ridCode);
    ArrayList<Company> findByMonth(String month);
    ArrayList<Company> findAll();
    Company save(Company company);
}
