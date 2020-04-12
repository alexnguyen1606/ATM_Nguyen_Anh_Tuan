package com.atm.controller;

import com.atm.builder.AccountBuilder;
import com.atm.controller.AdminController;
import com.atm.controller.HomeController;
import com.atm.controller.LoginController;
import com.atm.controller.UserController;
import com.atm.dao.AccountDAO;
import com.atm.dao.AtmDAO;
import com.atm.model.Account;
import com.atm.model.Atm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private static Atm atm;
    private static List<Account> accounts;
    private static  Account accountLogin;
    public MainController() {

    }

    public static void main(String[] args) throws IOException {
        int check = 0;
        Scanner scanner = new Scanner(System.in);
        HomeController homeController = new HomeController(scanner);
        LoginController loginController = new LoginController(scanner);
        AdminController adminController = new AdminController(scanner);
        UserController userController = new UserController(scanner);
       getAtm();
        setAccounts();
        boolean stop=true;
        do {
           switch (check){
               case 0 :
                   check =homeController.index(check);
                   break;
               case 1://đăng nhập
                    accountLogin = loginController.login();
                    check =2;
                   break;
               case 2:
                   if (accountLogin==null){
                       check = 0;
                   }else {
                        if (accountLogin.getRole().equalsIgnoreCase("admin")){

                            check = 3;
                        }else {
                            check= 4;
                        }
                   }
                   break;
               case 3://admin
                   if (accountLogin==null){
                        check = 0;
                   }else {
                       check= adminController.index();
                   }

                   break;
               case 4://user
                    if (accountLogin==null){
                        check = 0;
                    }else {
                        check = userController.index();
                    }
                   break;
               case 10://ngừng giao dịch
                   stop=false;
                   break;
               case 11:
                   System.out.println("Logout");
                   accountLogin=null;
                   check = 0;
                   break;
               default:
                   System.out.println("Logout");
                   check = 0;
                   break;
           }

        }while (stop);
    }
    public static void setAccounts(){
        accounts = new ArrayList<>();
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
        AccountDAO accountDAO = new AccountDAO();

        returnAccount(accounts);
    }
    public static List<Account> getAccounts(){
        return accounts;
    }
    public static void returnAccount(List<Account> list){
        accounts = list;

    }
    public static Account getAccountLogin(){
        return accountLogin;
    }
    public static void setAccount(Account account){
        accountLogin = account;
    }

    public static Atm getAtm() {
        return atm = new AtmDAO().getAtm();
    }

    public static void setAtm(Atm atm) {

        MainController.atm = atm;
    }
}
