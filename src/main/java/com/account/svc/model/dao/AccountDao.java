package com.account.svc.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDao {
    private String accountid;
    private String username;
    private String fullname;
    private String address;
}
