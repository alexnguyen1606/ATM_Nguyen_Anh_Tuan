package com.atm.model;

public class Account {
    private String fullName;
    private Long totalMoney;
    private  Long accountNumber;
    private String password;
    private Integer status;
    private String role;
    private Long tranferAmount;
    private Long pickMoney;

    public Account(Builder builder){
        this.fullName = builder.fullName;
        this.totalMoney = builder.totalMoney;
        this.accountNumber = builder.accountNumber;
        this.password = builder.password;
        this.status = builder.status;
        this.role = builder.role;
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

    public static class Builder {
        private String fullName;
        private Long totalMoney;
        private Long accountNumber;
        private String password;
        private Integer status;
        private String role;

        public Account build() {
            return new Account(this);
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setTotalMoney(Long totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        public Builder setAccountNumber(Long accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setStatus(Integer status) {
            this.status = status;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }
    }

}
