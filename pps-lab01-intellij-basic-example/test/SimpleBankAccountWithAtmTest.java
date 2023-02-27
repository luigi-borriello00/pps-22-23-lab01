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
    void testWithDrawWithAtm(){
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.withdraw(this.accountHolder.getId(), 50);
        assertEquals(48, this.bankAccount.getBalance());
    }


}
