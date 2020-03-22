package com.atm.serivce;

import com.atm.model.Account;

import java.util.List;

public interface IAccountService {
    boolean tranferMoney(Account account1,Account account2,Long money);
    Account authetication(List<Account> accounts,Account account);
    Account findByAccountNumber(List<Account> accounts,Long accountNumber);
    void getMoney(List<Account> accounts,Account account,Long money);
}
