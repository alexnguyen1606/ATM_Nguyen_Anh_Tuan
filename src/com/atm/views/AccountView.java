package com.atm.views;

import com.atm.model.Account;
import com.atm.serivce.IAccountService;
import com.atm.serivce.impl.AccountService;

import java.util.List;
import java.util.Scanner;

public class AccountView {
    private Scanner in;
    private IAccountService accountService;
    public AccountView(Scanner in){
        this.in = in;
        accountService = new AccountService();
    }
    public  Account  login(){
        System.out.println("----Đăng nhập----");
        System.out.println("Nhập số tài khoản:");
        Account account = new Account();
        account.setAccountNumber(in.nextLong());
        in.nextLine();
        System.out.println("Nhập mật khẩu:");
        account.setPassword(in.next());
        return account;
    }
    public int menu1(){
        int check = 10;
        System.out.println("--------------ATM---------------");
        System.out.println("nhập yêu cầu");
        System.out.println("0. Đăng nhập");
        System.out.print("Yêu cầu:");
        try {
            check = in.nextInt();
        }catch (Exception e){

        }
        in.nextLine();
        return check;
    }
    public int menuSuccess(){
        int check = 10;
        System.out.println("-----Nhập yêu cầu-----");
        System.out.println("---3.Kiểm tra thông tin tài khoản---");
        System.out.println("---4.Chuyển tiền---");
        System.out.println("---5.Rút tiền---");
        System.out.println("---6.Đăng xuất---");
        System.out.println("Nhập yêu cầu:");
        check = in.nextInt();
        return check;
    }
    public int info(List<Account> accounts,Account account){
        int check = 1;
        Account account1 = accountService.findByAccountNumber(accounts,account.getAccountNumber());
        System.out.println("------Thông tin tài khoản------");
        System.out.println("Số tài khoản:"+account1.getAccountNumber());
        System.out.println("Số dư:"+account1.getTotalMoney());
        System.out.println("1 .Trở lại");
        System.out.println("0 . Thoát");
        check  = in.nextInt();
        if (check==1){
            return 1;
        }else {
            return 10;
        }
    }
    public int tranferMoney(List<Account> accounts,Account accountLogin){
        int check = 10;
        if (accountLogin.getAccountNumber()==null){
            return check;
        }
        Account account = accountService.findByAccountNumber(accounts,accountLogin.getAccountNumber());
        System.out.println("---Chuyển tiền---");
        System.out.println("Nhập số tài khoản:");
        Long id = in.nextLong();
        System.out.println("Nhập số tiền chuyển:");
        Long money = in.nextLong();
        Account account1 = accountService.findByAccountNumber(accounts,id);
        if (account.getAccountNumber().equals(id)){
            System.out.println("Kiểm tra lại số tài khoản người nhận ");
            System.out.println("Nhập lại số tài khoản người nhận");
           check = 1;

        }
        else if (account1.getAccountNumber()==accountLogin.getAccountNumber()){
            System.out.println("Kiểm tra lại tài khoản");
            check = 1;
            return check;
        }  else if (account.getTotalMoney()<money){
            System.out.println("Tài khoản không đủ tiền");
            check = 1;
        }else {
            if (accountService.tranferMoney(account,account1,money)){

                System.out.println("Chuyển khoảng thành công!");
                System.out.println("Số tiền còn lại:"+accountLogin.getTotalMoney());
                check=1;
            }
            else {
                System.out.println("Tranfer fail");
                check = 1;
                return check;
            }
        }
        return check;
    }
    public int getMoney(List<Account> accounts,Account account){
        int check = 1;
        System.out.println("--------Rút tiền-------");
        System.out.println("Nhập số tiền:");
        Long money = in.nextLong();
        accountService.getMoney(accounts,account,money);
        return check;
    }
}
