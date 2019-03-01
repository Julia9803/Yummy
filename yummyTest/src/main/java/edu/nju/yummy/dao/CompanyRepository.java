package edu.nju.yummy.dao;

import edu.nju.yummy.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Integer> {
    Company findByRid(int rid);
    ArrayList<Company> findByMonth(String month);
    ArrayList<Company> findAll();
    Company save(Company company);
}
