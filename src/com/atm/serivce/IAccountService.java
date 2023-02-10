package com.atm.serivce;

import com.atm.model.Account;

public interface IAccountService {
    boolean transferMoney(Account account);
    Account authentication(Account account);
    Account findByAccountNumber(Long accountNumber);
    void pickMoney(Account account);
}
