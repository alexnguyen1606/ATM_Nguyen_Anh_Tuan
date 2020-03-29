package com.atm.builder;

public class AccountBuilder {
    private String fullName;
    private Long totalMoney;
    private  Long accountNumber;
    private String password;
    private Integer status;
    private String role;
    private AccountBuilder(Builder builder){
        fullName = builder.fullName;
        totalMoney = builder.totalMoney;
        accountNumber = builder.accountNumber;
        password = builder.password;
        status = builder.status;
        role = builder.role;

    }
    public static class Builder{
        private String fullName;
        private Long totalMoney;
        private  Long accountNumber;
        private String password;
        private Integer status;
        private String role;
        public AccountBuilder build(){
            return new AccountBuilder(this);
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
            this.password = password;return this;
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
    public String getFullName() {
        return fullName;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public Integer getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }
}
