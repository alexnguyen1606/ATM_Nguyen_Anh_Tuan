package com.atm.model;

public class Atm {
    private Long totalMoney;

    public Atm(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }
}
