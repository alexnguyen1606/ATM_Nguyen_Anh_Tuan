package com.atm.serivce;

import com.atm.model.Account;
import com.atm.model.Atm;

public interface IAtmService {
    void tranfer();
    void pickMoney(Account account);
    void addMoney(Long money);
    Atm findById();
}
