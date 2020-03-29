package com.atm.views;

import com.atm.controller.MainController;
import com.atm.model.Account;

import java.io.IOException;
import java.util.Scanner;

public class AdminView {
    private Scanner scanner;

    public AdminView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer index() throws IOException {


        System.out.println("-----------ADMIN----------");
        System.out.println("------Chức năng --------");
        System.out.println("1.Xem danh sách tài khoản");
        System.out.println("2.Thêm tài khoản");
        System.out.println("3.Kích hoạt tài khảon");
        System.out.println("4.Disable tài khoản");
        System.out.println("5.Đăng xuất");
        Integer adminCheck = scanner.nextInt();
        Integer check = null;
        switch (adminCheck){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("Chỉ được chọn các nút 1-5");
                index();
        }
        return adminCheck;
    }
    public Integer listUser(){
        System.out.println("------Danh sách tài khoản-------");
        for (Account account : MainController.getAccounts()){
            System.out.println("Chủ tài khoản:"+account.getFullName());
            System.out.println("Số tài khoản:"+account.getAccountNumber());
            if (account.getStatus()==1){
                System.out.println("---Trạng thái : Kích hoạt");
            }else {
                System.out.println("---Trạng thái : Disabled");
            }
        }
        return 0;
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
        Long accountNumber = null;
        System.out.println("Nhập số tài khoản:");
        accountNumber = scanner.nextLong();
        scanner.nextLine();
        return accountNumber;
    }
    public Account addAccount(){
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
}
