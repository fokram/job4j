package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void whenTransfer120of100ThenFalse() {
        var bank = new Bank();
        bank.addUser(new User("Ivan", "123456"));
        bank.addUser(new User("Ivan", "123456"));
        bank.addUser(new User("Andrew", "987"));
        bank.addUser(new User("Petr", "jhgfvbyt"));
        bank.addAccountToUser("123456", new Account("100500", 100));
        bank.addAccountToUser("123456", new Account("100800", 1000));
        bank.addAccountToUser("123456", new Account("3", 108));
        var result = bank.transferMoney("123456", "100500", "123456", "100800", 120);
        assertThat(result, is(false));
    }

    @Test
    public void whenTransfer100of100ThenTrue() {
        var bank = new Bank();
        bank.addUser(new User("Ivan", "123456"));
        bank.addUser(new User("Andrew", "987"));
        bank.addUser(new User("Petr", "jhgfvbyt"));
        bank.addAccountToUser("123456", new Account("100500", 100));
        bank.addAccountToUser("123456", new Account("100800", 1000));
        bank.addAccountToUser("123456", new Account("3", 108));
        var result = bank.transferMoney("123456", "100500", "123456", "100800", 100);
        assertThat(result, is(true));
    }

    @Test
    public void whenTransfer50of100ThenTrue() {
        var bank = new Bank();
        bank.addUser(new User("Ivan", "123456"));
        bank.addUser(new User("Andrew", "987"));
        bank.addUser(new User("Petr", "jhgfvbyt"));
        bank.addAccountToUser("123456", new Account("100500", 100));
        bank.addAccountToUser("123456", new Account("100800", 1000));
        bank.addAccountToUser("123456", new Account("3", 108));
        var result = bank.transferMoney("123456", "100500", "123456", "100800", 50);
        if (bank.getUserAccounts("123456").get(0).getValue() == 50 & bank.getUserAccounts("123456").get(1).getValue() == 1050) {
            result = true;
        } else {
            result = false;
        }
        assertThat(result, is(true));
    }

    @Test
    public void whenTransferFirstToUnknownAccountThenFalse() {
        var bank = new Bank();
        bank.addUser(new User("Ivan", "123456"));
        bank.addUser(new User("Andrew", "987"));
        bank.addUser(new User("Petr", "jhgfvbyt"));
        bank.addAccountToUser("123456", new Account("100500", 100));
        bank.addAccountToUser("123456", new Account("100800", 1000));
        bank.addAccountToUser("123456", new Account("3", 108));
        var result = bank.transferMoney("123456", "100500", "000000", "100800", 50);
        assertThat(result, is(false));
    }
}
