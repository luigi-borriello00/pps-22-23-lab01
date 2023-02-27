import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccountWithAtm;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest{


    private AccountHolder accountHolder;
    private BankAccountWithAtm bankAccount;

    @BeforeEach
    void beforeEach(){
        this.accountHolder = new AccountHolder("Luigi", "Borriello", 1);
        this.bankAccount = new SimpleBankAccountWithAtm(this.accountHolder, 0);
    }

    @Test
    void testDepositWithAtm(){
        final int EXPECTED_BALANCE = 99;
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        assertEquals(EXPECTED_BALANCE, this.bankAccount.getBalance());
    }

    @Test
    void testWithDrawWithAtm(){
        final int EXPECTED_BALANCE = 48;
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.withdraw(this.accountHolder.getId(), 50);
        assertEquals(EXPECTED_BALANCE, this.bankAccount.getBalance());
    }


}
