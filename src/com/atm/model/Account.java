package com.atm.model;

public class Account {
    private String fullName;
    private Long totalMoney;
    private  Long accountNumber;
    private String password;

    public Account(String fullName, Long totalMoney, Long accountNumber, String password) {
        this.fullName = fullName;
        this.totalMoney = totalMoney;
        this.accountNumber = accountNumber;
        this.password = password;
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
}
