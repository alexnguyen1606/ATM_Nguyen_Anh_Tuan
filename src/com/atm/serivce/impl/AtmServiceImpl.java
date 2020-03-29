package com.atm.serivce.impl;

import com.atm.controller.MainController;
import com.atm.model.Account;
import com.atm.model.Atm;
import com.atm.serivce.IAccountService;
import com.atm.serivce.IAtmService;

public class AtmServiceImpl implements IAtmService {
    @Override
    public void tranfer() {

    }

    @Override
    public void pickMoney(Account account) {

    }

    @Override
    public void addMoney(Long money) {
        Atm atm = MainController.getAtm();
        atm.setTotalMoney(atm.getTotalMoney()+money);
        MainController.setAtm(atm);
    }
}
