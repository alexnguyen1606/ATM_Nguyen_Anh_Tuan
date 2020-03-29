package com.atm.model;

import com.atm.builder.AccountBuilder;

public class Account {
    private String fullName;
    private Long totalMoney;
    private  Long accountNumber;
    private String password;
    private Integer status;
    private String role;
    private Long tranferAmount;
    private Long pickMoney;

    public Account(AccountBuilder builder){
        this.fullName = builder.getFullName();
        this.totalMoney = builder.getTotalMoney();
        this.accountNumber = builder.getAccountNumber();
        this.password = builder.getPassword();
        this.status = builder.getStatus();
        this.role = builder.getRole();
    }
    public Account() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public  Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getTranferAmount() {
        return tranferAmount;
    }

    public void setTranferAmount(Long tranferAmount) {
        this.tranferAmount = tranferAmount;

    }

    public Long getPickMoney() {
        return pickMoney;
    }

    public void setPickMoney(Long pickMoney) {
        this.pickMoney = pickMoney;
    }
}
