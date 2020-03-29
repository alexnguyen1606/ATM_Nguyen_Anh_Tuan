package com.atm.serivce.impl;

import com.atm.controller.MainController;
import com.atm.model.Account;
import com.atm.model.Atm;
import com.atm.serivce.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    @Override
    public boolean tranferMoney(Account account2) {
        List<Account> accounts = MainController.getAccounts();
        Account account = MainController.getAccountLogin();
        if (account.getTotalMoney()<account2.getTranferAmount()){
            System.out.println("Số tiền bạn k đủ để thực hiện giao dịch");
            return false;
        }else {
            Long ammountTranfer = account2.getTranferAmount();
            Boolean check = false;
            for (Account account1 : accounts){
                if (account1.getAccountNumber().equals(account2.getAccountNumber())){
                    account1.setTotalMoney(account1.getTotalMoney()+ammountTranfer);
                    check = true;
                    break;
                }
            }
            if (check){
                for (Account account1 : accounts){
                    if (account1.getAccountNumber().equals(account.getAccountNumber())){
                        account1.setTotalMoney(account1.getTotalMoney()+ammountTranfer);
                        break;
                    }
                }
                System.out.println("Chuyển khoản thành công");
                MainController.returnAccount(accounts);
                return true;
            }
            return false;
        }

    }

    @Override
    public Account authetication(List<Account> accounts, Account account) {
        Long accountNumber = account.getAccountNumber();
        Account account1 = null;
        String password = account.getPassword();

        for (Account item: accounts){
            if (item.getPassword().equals(password) && item.getAccountNumber().equals(accountNumber) && item.getStatus().equals(1)){
                account1 = item;
                break;
            }
        }
        return account1;
    }

    @Override
    public Account findByAccountNumber( Long accountNumber) {
        List<Account> accounts = MainController.getAccounts();
        for (Account account : accounts){
            if (account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    @Override
    public  void pickMoney(Account account) {
        Atm atm = MainController.getAtm();
        Account accountLogin = MainController.getAccountLogin();
        List<Account> accounts =MainController.getAccounts();
        if (atm.getTotalMoney()<account.getPickMoney()){
            System.out.println("ATM Không đủ tiền mặt");
        }else if (accountLogin.getTotalMoney()<account.getPickMoney()){
            System.out.println("Số tiền nhập quá số dư");

        }else {
            Long pickMoney = account.getPickMoney();
            for (Account item : accounts){
                if (accountLogin.getAccountNumber().equals(item.getAccountNumber())){
                    item.setTotalMoney(item.getTotalMoney()-pickMoney);
                    atm.setTotalMoney(atm.getTotalMoney()-pickMoney);
                }
            }
            MainController.returnAccount(accounts);
            MainController.setAtm(atm);
        }
    }


}
