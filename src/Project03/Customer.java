package Project03;

import java.util.ArrayList;

public class Customer {
    String username;
    String password;
    ArrayList<Account> accounts;

    public Customer(String username, String password, Account account) {
        this.username = username;
        this.password = password;
        this.accounts = new ArrayList<Account>();
        this.accounts.add(account);
    }
}
