import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccountWithAtm;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest{


    private AccountHolder accountHolder;
    private BankAccountWithAtm bankAccount;

    private final int DEPOSIT_AMOUNT = 100;

    @BeforeEach
    void beforeEach(){
        this.accountHolder = new AccountHolder("Luigi", "Borriello", 1);
        this.bankAccount = new SimpleBankAccountWithAtm(this.accountHolder, 0);
    }

    @Test
    void testDepositWithAtm(){
        final int EXPECTED_BALANCE = 99;
        this.bankAccount.deposit(this.accountHolder.getId(), DEPOSIT_AMOUNT);
        assertEquals(EXPECTED_BALANCE, this.bankAccount.getBalance());
    }

    @Test
    void testWithDrawWithAtm(){
        final int EXPECTED_BALANCE = 48;
        final int WITHDRAW_AMOUNT = 50;
        this.bankAccount.deposit(this.accountHolder.getId(), DEPOSIT_AMOUNT);
        this.bankAccount.withdraw(this.accountHolder.getId(), WITHDRAW_AMOUNT);
        assertEquals(EXPECTED_BALANCE, this.bankAccount.getBalance());
    }


}
