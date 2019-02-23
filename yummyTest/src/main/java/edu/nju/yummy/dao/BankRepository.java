package edu.nju.yummy.dao;

import edu.nju.yummy.model.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank,Integer> {
    Bank findByBankAccount(String bankAccount);
    void deleteById(int id);
}
