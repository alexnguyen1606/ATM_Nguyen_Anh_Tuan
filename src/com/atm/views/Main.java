package com.atm.views;

import com.atm.model.Account;
import com.atm.serivce.IAccountService;
import com.atm.serivce.impl.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int check=10;
    private static Account accountLogin = null;
    public static void main(String[] args) {
        IAccountService accountService = new AccountService();
        List<Account> accounts = getListAccount();
        Scanner in = new Scanner(System.in);
        AccountView accountView = new AccountView(in);
        do {
            switch (check){
                case 10:
                    check  =accountView.menu1();
                    break;
                case 0:
                    Account account = accountView.login();
                    accountLogin=accountService.authetication(accounts,account);
                    try {
                        if (!accountLogin.getAccountNumber().equals(null)){
                            check=1;
                            System.out.println("Đăng nhập thành công");
                        }else {
                            System.out.println("Đăng nhập k thành công");
                            check = 10;
                            break;
                        }
                    }catch (Exception e){
                        check = 10;
                        System.out.println("Đăng nhập k thành công");
                        break;
                    }
                case 1:
                    if (accountLogin!=null){
                        check = accountView.menuSuccess();
                        break;
                    }else {
                        check =10;
                        break;
                    }
                case 3:
                    check = accountView.info(accounts,accountLogin);
                    break;
                case 4:
                    check = accountView.tranferMoney(accounts,accountLogin);
                    break;
                case 5:
                    if (accountLogin==null){
                        check=10;
                        break;
                    }
                    check =accountView.getMoney(accounts,accountLogin);
                    break;
                case 6:
                    accountLogin = null;
                    check = 10;
                    break;
                case 7:
                    for (Account account1 : accounts){
                        System.out.println("Money:"+account1.getTotalMoney());
                    }
                    check=1;
                    break;
                default:
                    System.out.println("fail");
                    check =10;
                    break;
            }
        }while (true);
    }
    public static List<Account> getListAccount(){
        List<Account> accounts = new ArrayList<>();
        Account account1 = new Account("Nguyễn Văn A",1000000L,9209123212L,"12344");
        Account account2 = new Account("Nguyễn Văn B",1000000L,9209124422L,"12344");
        Account account3 = new Account("Nguyễn Văn C",1000000L,9209125332L,"12344");
        Account account4 = new Account("Nguyễn Văn D",1000000L,9209128789L,"12344");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        return  accounts;
    }
}
