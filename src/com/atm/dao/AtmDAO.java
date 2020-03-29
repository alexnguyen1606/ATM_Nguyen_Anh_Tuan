package com.atm.dao;

import com.atm.builder.AccountBuilder;
import com.atm.controller.MainController;
import com.atm.model.Account;
import com.atm.model.Atm;

import java.util.ArrayList;
import java.util.List;

public class AtmDAO {

    private static Atm atm;
    public AtmDAO(){
        atm = new Atm(1000000000L);
    }
    public static Atm getAtm() {
        return atm;
    }

    public static void setAtm(Atm atm2) {
     atm = atm2;
    }
}
