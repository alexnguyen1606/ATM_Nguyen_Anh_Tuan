package com.atm.serivce;

import com.atm.model.Account;

import java.util.List;

public interface IAccountService {
    boolean tranferMoney(Account account);
    Account authetication(List<Account> accounts,Account account);
    Account findByAccountNumber(Long accountNumber);
    void pickMoney(Account account);
}
