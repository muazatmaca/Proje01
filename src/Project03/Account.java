package Project03;

public class Account {public String type;
    String number;
    double balance;


    public Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }
//    public Customer confirmUsernameAndPassword(ArrayList<Customer> customers, String username, String password) {
//        for (Customer customer : customers) {
//            if (customer.username.equals(username) && customer.password.equals(password)) {
//                return customer;
//            }
//        }
//        return null;
//
//
//    }
//    public Account confirmAccountNumber(Customer customer, String chosen) {
//        for (Account account : customer.accounts) {
//            if (account.number.equals(chosen)) {
//                return account;
//            }
//        }
//        return null;
//    }

    public void deposit(int amountToDeposit) {
    }

    public boolean withdraw(double amount) {
        return false;
    }

}
