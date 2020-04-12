package com.atm.serivce.impl;

import com.atm.controller.MainController;
import com.atm.dao.AtmDAO;
import com.atm.model.Account;
import com.atm.model.Atm;
import com.atm.serivce.IAccountService;
import com.atm.serivce.IAtmService;

public class AtmServiceImpl implements IAtmService {
    private AtmDAO atmDAO;

    public AtmServiceImpl() {
        this.atmDAO =new AtmDAO();
    }

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

    @Override
    public Atm findById() {
        return atmDAO.getAtm();
    }
}
