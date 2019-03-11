package edu.nju.yummy.dao;

import edu.nju.yummy.entity.Bank;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BankRepositoryTest {
    @Autowired BankRepository bankRepository;
    Bank bank = new Bank();
    String account = "11111111111113";
    String password = "123";

    @Test
    public void findByBankAccount() {
        bank.setBankAccount(account);
        bank.setPassword(password);
        bank.setBalance(10000.00);
        bankRepository.save(bank);
        Bank bank1= bankRepository.findByBankAccount(account);
        System.out.println(bank1.getBalance());
        assertNotNull(bank1);
    }
}