package com.atm.views;

import com.atm.dao.AccountDAO;
import com.atm.factory.InputFactory;
import com.atm.model.Account;
import com.atm.model.Atm;

import java.io.IOException;
import java.util.Scanner;

public class AdminView {

    private Scanner scanner;
    private AccountDAO accountDAO;

    public AdminView() {
        this.scanner = InputFactory.getInput();
        this.accountDAO = AccountDAO.getInstance();
    }

    public Integer index() throws IOException {

        System.out.println("-----------ADMIN----------");
        System.out.println("------Chức năng --------");
        System.out.println("1.Xem danh sách tài khoản");
        System.out.println("2.Thêm tài khoản");
        System.out.println("3.Kích hoạt tài khảon");
        System.out.println("4.Disable tài khoản");
        System.out.println("5.Thông tin ATM");
        System.out.println("6.Đăng xuất");
        Integer adminCheck = scanner.nextInt();
        if(adminCheck < 1 || adminCheck > 6) {
            System.out.println("Chỉ được chọn các nút 1-6");
            return index();
        }

        return adminCheck;
    }
    public void listUser(){
        System.out.println("------Danh sách tài khoản-------");
        for (Account account : accountDAO.getAccounts()){
            System.out.println("Chủ tài khoản:"+account.getFullName());
            System.out.println("Số tài khoản:"+account.getAccountNumber());
            if (account.getStatus()==1){
                System.out.println("---Trạng thái : Kích hoạt");
            }else {
                System.out.println("---Trạng thái : Disabled");
            }
        }
    }
    public Long active(){
        System.out.println("------Kích hoạt tài khoản-------");
        Long accountNumber = null;
        System.out.println("Nhập số tài khoản:");
        accountNumber = scanner.nextLong();
        scanner.nextLine();
        return accountNumber;
    }
    public Long disable(){
        System.out.println("------Disable tài khoản-------");
        System.out.println("Nhập số tài khoản:");
        Long accountNumber = scanner.nextLong();
        scanner.nextLine();
        return accountNumber;
    }
    public Account formInputAccount(){
        Account account = new Account();
        System.out.println("------Thêm tài khoản---------");
        System.out.println("Nhập số tài khoản:");
        account.setAccountNumber(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Nhập tên chủ tài khoản:");
        account.setFullName(scanner.nextLine());
        System.out.println("Nhập mật khẩu");
        account.setPassword(scanner.nextLine());
        System.out.println("Nhập số dư:");
        account.setTotalMoney(scanner.nextLong());
        System.out.println("Nhập trạng thái tài khoản");
        System.out.println("---1:active");
        System.out.println("---0:disable");
        account.setStatus(scanner.nextInt());
        System.out.println("Nhập quyền tài khoản:");
        System.out.println("----1.Admin");
        System.out.println("----2.User");
        int check = scanner.nextInt();
        if (check==1){
            account.setRole("admin");
        }else {
            account.setRole("user");
        }
        scanner.nextLine();
        return account;
    }
    public Integer atmInfo(Atm atm){
        System.out.println("------Thông tin ATM-------");
        System.out.println("----Số tiền còn lại:"+atm.getTotalMoney());
        return 0;
    }
}
