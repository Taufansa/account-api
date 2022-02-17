package com.account.svc.model.repository;

import com.account.svc.model.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
    Account findByAccountid(String accountid);
    Account findByUsername(String username);
}
