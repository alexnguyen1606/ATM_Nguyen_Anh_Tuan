package com.atm.serivce;

import com.atm.model.Account;

public interface IAdminService {
    public void activeAccount(Long accountId);
    public void disableAcount(Long accuntId);
    Account addAccount(Account account);
}
