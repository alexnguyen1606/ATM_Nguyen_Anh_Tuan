package com.atm.controller;

import com.atm.model.Account;
import com.atm.serivce.IAccountService;
import com.atm.serivce.impl.AccountServiceImpl;
import com.atm.views.LoginView;

import java.util.Scanner;

public class LoginController {
    private LoginView loginView;
    private Scanner scanner;
    private IAccountService accountService;
    public LoginController(Scanner scanner){

        this.scanner = scanner;
        loginView = new LoginView(this.scanner);
        accountService = new AccountServiceImpl();
    }
    public Account login(){
        Integer check = null;
        Integer homeCheck= 1;
        Boolean stop=true;
        Account account = null;
        while (stop){

            switch (homeCheck){
                case 1:
                    account = loginView.login();
                    account = accountService.authetication(account);
                    if (account==null){
                        stop = true;
                        homeCheck = 2;
                    }else {
                        stop = false;
                    }
                    break;
                case 2:
                    loginView.loginFail(scanner);
                    check = 0;
                    stop = false;
                    break;
                default:
                    stop = false;
                    break;
            }
        }

        return account;

    }
}
