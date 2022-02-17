package com.account.svc.services;

import com.account.svc.model.dao.AccountDao;
import com.account.svc.model.entity.Account;
import com.account.svc.model.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAll() throws Exception {
        try {
            return accountRepository.findAll();
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }

    }

    public Account getById(String id) throws Exception {
        try {
            return accountRepository.findByAccountid(id);
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public Account getByUsername(String username) throws Exception {
        try {
            return accountRepository.findByUsername(username);
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public Account createAccount(AccountDao accountDao) throws Exception {
        try {
            Account account = getByUsername(accountDao.getUsername());
            if (Objects.isNull(account)){
                Account newAcc = new Account(
                        null,
                        accountDao.getUsername(),
                        accountDao.getFullname(),
                        accountDao.getAddress()
                );
                return accountRepository.save(newAcc);
            } else {
                return new Account();
            }
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public Account updateAccount(AccountDao accountDao) throws Exception {
        try {
            Account account = getById(accountDao.getAccountid());
            if (Objects.nonNull(account)){
                account.setUsername(accountDao.getUsername());
                account.setFullname(accountDao.getFullname());
                account.setAddress(accountDao.getAddress());
                return accountRepository.save(account);
            } else {
                return new Account();
            }
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public void deleteAccount(String id) throws Exception {
        try {
            Account account = getById(id);
            accountRepository.delete(account);
        } catch (Exception e) {
            System.out.println("exception : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
