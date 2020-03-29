package com.atm.serivce;

import com.atm.model.Account;

public interface IAtmService {
    public void tranfer();
    void pickMoney(Account account);
    void addMoney(Long money);
}
