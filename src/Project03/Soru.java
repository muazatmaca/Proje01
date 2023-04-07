package Project03;

import java.util.ArrayList;
import java.util.Scanner;

public class Soru {
    public static void main(String[] args) {
        ArrayList<Actions> actions = new ArrayList<Actions>();
        ArrayList<Customer> customers = new ArrayList<Customer>();

        actions.add(new Actions("Deposit", 1));
        actions.add(new Actions("Withdraw", 2));
        actions.add(new Actions("Transfer", 3));
        actions.add(new Actions("Exit", 4));

        customers.add(new Customer("user1", "pass1", new Account("1234", 100)));
        customers.add(new Customer("user2", "pass2", new Account("2345", 200)));
        customers.add(new Customer("user3", "pass3", new Account("3456", 300)));

        Scanner scan = new Scanner(System.in);

        Customer activeCustomer = null;
        Account selectedAccount = null;

        while (true) {
            System.out.print("Lütfen kullanıcı adınızı girin: ");
            String username = scan.nextLine();
            System.out.print("Lütfen şifrenizi girin: ");
            String password = scan.nextLine();

            activeCustomer = confirmUsernameAndPassword(customers, username, password);
            if (activeCustomer != null) {
                System.out.println("Başarıyla giriş yaptınız.");
                break;
            }
            System.out.println("Sistemde kayıtlı böyle bir kullanıcı bulunamadı. Lütfen tekrar deneyin.");
        }

        while (true) {
            System.out.println("Yapmak istediğiniz işlemi seçin: ");
            for (int i = 0; i < actions.size(); i++) {
                System.out.println(actions.get(i).description + " - " + (i + 1));
            }

            int userChoice = scan.nextInt();
            scan.nextLine();

            switch (userChoice) {
                case 1: {
                    System.out.println("Para yatırmak istediğiniz hesap numarasını seçiniz: ");
                    int i = 1;
                    for (Account account : activeCustomer.accounts) {
                        System.out.println(i + ". " + account.number);
                        i++;
                    }
                    userChoice = scan.nextInt();
                    scan.nextLine();
                    if (userChoice < 1 || userChoice > activeCustomer.accounts.size()) {
                        System.out.println("Geçersiz hesap numarası seçtiniz. Lütfen tekrar deneyin.");
                        continue;
                    }
                    Account chosenAccount = activeCustomer.accounts.get(userChoice - 1);
                    System.out.println("Yatırmak istediğiniz tutarı giriniz: ");
                    double amount = scan.nextDouble();
                    scan.nextLine();
                    chosenAccount.balance += amount;
                    System.out.println("Para yatırma işleminiz başarıyla gerçekleştirildi. Yeni bakiyeniz: " + chosenAccount.balance);

                    break;
                }
                case 2: {
                    for (int i = 0; i < activeCustomer.accounts.size(); i++) {
                        System.out.println((i + 1) + " - " + activeCustomer.accounts.get(i).number);
                    }
                    System.out.println("Lütfen para çekmek istediğiniz hesap numarasını seçin: ");
                    int chosenAccountIndex = scan.nextInt();
                    scan.nextLine();
                    if (chosenAccountIndex < 1 || chosenAccountIndex > activeCustomer.accounts.size()) {
                        System.out.println("Hatalı hesap numarası seçimi yaptınız. Lütfen tekrar deneyin.");
                        continue;
                    }
                    Account chosenAccount = activeCustomer.accounts.get(chosenAccountIndex - 1);
                    System.out.println("Lütfen çekmek istediğiniz miktarı girin: ");
                    double amount = scan.nextDouble();
                    scan.nextLine();

                    if (amount > chosenAccount.balance) {
                        System.out.println("Çekmek istediğiniz miktar hesaptaki bakiyeden fazla. Lütfen tekrar deneyin.");
                        continue;
                    }

                    chosenAccount.balance -= amount;
                    System.out.println("Para çekme işlemi başarıyla gerçekleşti. Yeni bakiyeniz: " + chosenAccount.balance);
                    break;
                }
                case 3: {
                    System.out.println("Hangi hesaptan transfer yapmak istiyorsunuz?");
                    for (int i = 0; i < activeCustomer.accounts.size(); i++) {
                        System.out.println(activeCustomer.accounts.get(i).number + " - " + activeCustomer.accounts.get(i).type);
                    }
                    String chosen = scan.nextLine();
                    Account sourceAccount = confirmAccountNumber(activeCustomer, chosen);
                    if (sourceAccount == null) {
                        System.out.println("Geçersiz hesap numarası. Lütfen tekrar deneyin.");
                        continue;
                    }
                    System.out.println("Hangi hesaba transfer yapmak istiyorsunuz?");
                    String targetAccountNumber = scan.nextLine();
                    System.out.println("Ne kadar para transfer etmek istiyorsunuz?");
                    double amount = scan.nextDouble();
                    if (sourceAccount.withdraw(amount)) {
                        for (Customer c : customers) {
                            for (Account a : c.accounts) {
                                if (a.number.equals(targetAccountNumber)) {
                                    a.deposit((int) amount);
                                    System.out.println("Para transferi başarıyla gerçekleşti.");
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Yetersiz bakiye. Para transferi gerçekleştirilemedi.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Çıkış yapmak istediğinize emin misiniz? E/H");
                    String choice = scan.nextLine();
                    if (choice.equalsIgnoreCase("E")) {
                        break;
                    }
                    break;
                }
                default:
                    System.out.println("Geçersiz seçim yaptınız. Lütfen tekrar deneyin.");
                    break;
            }

        }
    }
    public static Customer confirmUsernameAndPassword(ArrayList<Customer> customers, String username, String password) {
        for (Customer customer : customers) {
            if (customer.username.equals(username) && customer.password.equals(password)) {
                return customer;
            }
        }
        return null;


    }
    public static Account confirmAccountNumber(Customer customer, String chosen) {
        for (Account account : customer.accounts) {
            if (account.number.equals(chosen)) {
                return account;
            }
        }
        return null;
    }

}

