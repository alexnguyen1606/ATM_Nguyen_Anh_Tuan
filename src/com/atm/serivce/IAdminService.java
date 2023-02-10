package com.atm.serivce;

import com.atm.model.Account;

public interface IAdminService {

    void activeAccount(Long accountId);
    void disableAccount(Long accountId);
    Account addAccount(Account account);

}
