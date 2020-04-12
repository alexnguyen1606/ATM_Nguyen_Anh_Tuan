package com.atm.model;

public class Atm {
    private static Long totalMoney=1_000_000_000L;
    private Long id;
    public Atm() {

    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
