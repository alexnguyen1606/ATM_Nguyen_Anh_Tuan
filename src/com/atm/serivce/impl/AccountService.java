package com.atm.serivce.impl;

import com.atm.model.Account;
import com.atm.serivce.IAccountService;
import com.atm.views.Main;

import java.util.List;

public class AccountService implements IAccountService {
    @Override
    public boolean tranferMoney(Account account1, Account destinationAccount, Long money) {
        if (!(money<=0) && (account1.getTotalMoney()>=money)){
            account1.setTotalMoney(account1.getTotalMoney()-money);
            destinationAccount.setTotalMoney(destinationAccount.getTotalMoney()+money);
            return true;
        }
        return false;
    }

    @Override
    public Account authetication( List<Account> accounts,Account account) {

        Long accountNumber = account.getAccountNumber();
        String password = account.getPassword();
        for (Account item: accounts){
            if (item.getPassword().equals(password) && account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    @Override
    public Account findByAccountNumber(List<Account> accounts,Long accountNumber) {
        for (Account account : accounts){
            if ( account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return new Account();
    }

    @Override
    public void getMoney(List<Account> accounts, Account account, Long money) {

        for (Account item : accounts){
            if ( account.getAccountNumber().equals(item.getAccountNumber())){
                if (item.getTotalMoney()>=money){
                    item.setTotalMoney(item.getTotalMoney()-money);
             //       account.setTotalMoney(account.getTotalMoney()-money);
                    System.out.println("Rút tiền thành công");
                    System.out.println("Số tiền còn lại:"+item.getTotalMoney());
                    break;
                }else {
                    System.out.println("Rút tiền không thành công");
                }
            }
        }
    }

}
