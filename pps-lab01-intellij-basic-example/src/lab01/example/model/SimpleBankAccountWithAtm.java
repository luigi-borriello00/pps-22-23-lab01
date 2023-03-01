package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccountWithAtm {


    private static final int BANK_FEE = 1;
    @Override
    public void deposit(int userID, double amount) {
        super.deposit(userID, amount - BANK_FEE);
    }

    @Override
    public void withdraw(int userID, double amount) {
        super.withdraw(userID, amount + BANK_FEE);
    }

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }
}
