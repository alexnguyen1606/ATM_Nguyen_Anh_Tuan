package com.atm.dao;

import com.atm.builder.AccountBuilder;
import com.atm.controller.MainController;
import com.atm.model.Account;
import com.atm.model.Atm;

import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private static   List<Account> accounts;
    private static   Account account;
    public AccountDAO(){
        setAccounts();
    }
    public  void setAccounts(){
        this.accounts = new ArrayList<>();
        AccountBuilder builder1 = new AccountBuilder.Builder().setAccountNumber(9209123210L).setFullName("Nguyễn Văn A").setTotalMoney(1000000L)
                .setPassword("1234").setStatus(1).setRole("admin").build();
        AccountBuilder builder2 = new AccountBuilder.Builder().setAccountNumber(9209123212L).setFullName("Nguyễn Văn A").setTotalMoney(1000000L)
                .setPassword("1234").setStatus(1).setRole("user").build();
        AccountBuilder builder3 = new AccountBuilder.Builder().setAccountNumber(9209123215L).setFullName("Nguyễn Văn A").setTotalMoney(1000000L)
                .setPassword("1234").setStatus(1).setRole("user").build();
        AccountBuilder builder4 = new AccountBuilder.Builder().setAccountNumber(9209123218L).setFullName("Nguyễn Văn A").setTotalMoney(1000000L)
                .setPassword("1234").setStatus(1).setRole("user").build();

        Account account1 = new Account(builder1);
        Account account2 = new Account(builder2);
        Account account3 = new Account(builder3);
        Account account4 = new Account(builder4);

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        returnAccount(accounts);
    }
    public List<Account> getAccounts(){
        return accounts;
    }
    public  void returnAccount(List<Account> list){
        accounts = list;

    }
    public  Account getAccount(){
        return account;
    }
    public void setAccount(Account account){
        this.account = account;
    }


}
