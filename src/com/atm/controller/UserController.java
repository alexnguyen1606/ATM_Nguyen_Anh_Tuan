package com.atm.controller;

import com.atm.model.Account;
import com.atm.serivce.IAccountService;
import com.atm.serivce.impl.AccountServiceImpl;
import com.atm.views.UserView;

import java.util.Scanner;

public class UserController {
    private Scanner scanner;
    private UserView userView;
    private IAccountService accountService;
    public UserController(Scanner scanner) {
        this.scanner = scanner;
        this.userView = new UserView(this.scanner);
        this.accountService = new AccountServiceImpl();
    }
    public Integer index(){
        Integer userCheck = 0;
        Boolean stop = true;
        Account account = null;

        do {
            switch (userCheck){
                case 0:
                   userCheck= userView.index();
                   break;
                case 1:
                    userCheck = userView.checkBalance();
                    break;
                case 2:
                    account = userView.tranferMoney();
                    accountService.tranferMoney(account);
                    account = null;
                    userCheck = 0;
                    break;
                case 3:
                    account = userView.pickMoney();
                    accountService.pickMoney(account);
                    account = null;
                    userCheck = 0;
                    break;
                case 4:
                    stop = false;
                    userCheck = 11;
                    break;
            }
        }while (stop);
        return userCheck;
    }
}
