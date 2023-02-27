package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccountWithAtm {

    @Override
    public void deposit(int userID, double amount) {
        super.deposit(userID, amount - 1);
    }

    @Override
    public void withdraw(int userID, double amount) {
        super.withdraw(userID, amount + 1);
    }

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }
}
