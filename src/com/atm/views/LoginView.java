package com.atm.views;

import com.atm.controller.LoginController;
import com.atm.model.Account;

import java.util.Scanner;

public class LoginView {
    private LoginController loginController;
    private Scanner in;
    public LoginView(Scanner scanner){
        this.in =scanner;
        //loginController = new LoginController();

    }
    public Account login(){
        Integer check = null;
        System.out.println("----Đăng nhập----");
        System.out.println("Nhập số tài khoản:");
        Account account = new Account();
        account.setAccountNumber(in.nextLong());
        in.nextLine();
        System.out.println("Nhập mật khẩu:");
        account.setPassword(in.next());
        return account;
    }
    public void  loginFail(Scanner in){
        System.out.println("----------------ATM---------------");
        System.out.println("----------Fail----------");
    }

}
