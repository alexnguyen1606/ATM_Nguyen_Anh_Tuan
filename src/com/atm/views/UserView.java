package com.atm.views;

import com.atm.controller.MainController;
import com.atm.model.Account;

import java.util.Scanner;

public class UserView {
    private Scanner scanner;

    public UserView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer index(){
        System.out.println("------------ATM---------");
        System.out.println("------Chức năng --------");
        System.out.println("1.Kiểm tra số dư");
        System.out.println("2.Chuyển tiền");
        System.out.println("3.Rút tiền");
        System.out.println("4.Đăng xuất");
        Integer userCheck = scanner.nextInt();
        switch (userCheck){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Chỉ được chọn các nút 1-4");
                index();
        }
        return userCheck;
    }
    public Integer checkBalance(){
        Account account = MainController.getAccountLogin();
        System.out.println("Số dư:"+ account.getTotalMoney());
        return 0;
    }
    public Account tranferMoney(){
        Account account = new Account();
        System.out.println("------Chuyển tiền-------");
        System.out.println("Nhập số tài khoản:");
        account.setAccountNumber(scanner.nextLong());
        System.out.println("Nhập số tiền chuyển:");
        account.setTranferAmount(scanner.nextLong());
        scanner.nextLine();
        return account;
    }
    public Account pickMoney(){
        Account account = new Account();
        System.out.println("------Rút tiền--------");
        System.out.println("Nhập số tiền:");
        account.setPickMoney(scanner.nextLong());
        scanner.nextLine();
        return account;
    }
}
