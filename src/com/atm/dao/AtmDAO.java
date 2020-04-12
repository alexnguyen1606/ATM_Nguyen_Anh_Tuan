package com.atm.dao;

import com.atm.model.Atm;

public class AtmDAO {

    private static Atm atm;
    public AtmDAO(){
        this.atm = new Atm();
    }
    public  Atm getAtm() {
        return atm;
    }

    public  void setAtm(Atm atm2) {
     this.atm = atm2;
    }
}
