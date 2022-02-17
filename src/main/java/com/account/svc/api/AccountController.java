package com.account.svc.api;

import com.account.svc.model.dao.AccountDao;
import com.account.svc.model.entity.Account;
import com.account.svc.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account-svc/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/getall")
    public List<Account> fetchAll() throws Exception {
        return accountService.getAll();
    }

    @GetMapping("/getbyid")
    public Account getById(@RequestParam("id") String id) throws Exception {
        return accountService.getById(id);
    }

    @PostMapping("/create")
    public Account createAccount(@RequestBody AccountDao accountDao) throws Exception {
        return accountService.createAccount(accountDao);
    }

    @PatchMapping("/update")
    public Account updateAccount(@RequestBody AccountDao accountDao) throws Exception {
        return accountService.updateAccount(accountDao);
    }

    @DeleteMapping("/delete")
    public void deleteAccount(@RequestParam("id") String id) throws Exception {
        accountService.deleteAccount(id);
    }
}
