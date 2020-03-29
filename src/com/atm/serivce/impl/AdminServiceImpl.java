package com.atm.serivce.impl;

import com.atm.model.Account;
import com.atm.serivce.IAdminService;
import com.atm.controller.MainController;

import java.util.List;

public class AdminServiceImpl implements IAdminService {
    @Override
    public void activeAccount(Long accountId) {
        List<Account> accounts = MainController.getAccounts();
        for (Account account : accounts){
            if (account.getAccountNumber().equals(accountId)){
                account.setStatus(1);
            }
        }
        MainController.returnAccount(accounts);
    }

    @Override
    public void disableAcount(Long accountId) {
        List<Account> accounts = MainController.getAccounts();
        for (Account account : accounts){
            if (account.getAccountNumber().equals(accountId)){
                account.setStatus(0);
            }
        }
        MainController.returnAccount(accounts);
    }

    @Override
    public Account addAccount(Account account) {
        List<Account> accounts = MainController.getAccounts();
        Boolean check = true;
        for (Account item : accounts){
            if (item.getAccountNumber().equals(account.getAccountNumber())){
                check = false;
                break;
            }
        }
        if (check){
            accounts.add(account);
            MainController.returnAccount(accounts);
            System.out.println("Thêm tài khoản thành công");
        }else {
            System.out.println("Số tài khoản đã tồn tại");
        }
        return account;
    }
}
