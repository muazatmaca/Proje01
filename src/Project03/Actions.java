package Project03;

public class Actions {
    int deposit;
    int withdraw;
    int transfer;
    String exit;
    String description;
    int number;

    public Actions(String description, int number, int deposit, int withdraw, int transfer, String exit) {
        this.description = description;
        this.number = number;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.transfer = transfer;
        this.exit = exit;

    }

    public Actions(String deposit, int number) {
    }
}
