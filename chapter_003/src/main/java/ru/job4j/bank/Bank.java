package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Bank {
    private Map<User, ArrayList<Account>> bank = new HashMap<>();

    //добавление пользователя
    public void addUser(User user) {
        bank.put(user, new ArrayList<>());
    }

    //удаление пользователя
    public void deleteUser(User user) {
        bank.remove(user);
    }

    //поиск пользователя в банке по паспорту
    private User findUserByPassport(String passport) throws UserChecks {
        User result = null;
        for (User user:bank.keySet()) {
            if (user.getPassport() == passport) {
                result = user;
                break;
            }
        }
        if (result == null) {
            throw new UserChecks("Пользователь не найден");
        }
        return result;
    }

    //найти счет у пользователя
    private Account findAccountByRequisites(ArrayList<Account> accounts, String requisites) throws UserChecks {
        Account result = null;
        for (Account account : accounts) {
            if (account.getRequisites() == requisites) {
                result = account;
                break;
            }
        }
        if (result == null) {
            throw new UserChecks("Счет пользователя не найден");
        }
        return result;
    }

    //добавить счёт пользователю
    public void addAccountToUser(String passport, Account account) throws UserChecks {
        try {
            bank.get(findUserByPassport(passport)).add(account);
        } catch (UserChecks uc) {
            System.out.println("Попробуйте ещё раз.");
        }
    }

    //удалить один счёт пользователя.
    public void deleteAccountFromUser(String passport, Account account) {
        bank.remove(findUserByPassport(passport));

    }

    //получить список счетов для пользователя
    public ArrayList<Account> getUserAccounts(String passport) {
        return bank.get(findUserByPassport(passport));
    }

    //метод для перечисления денег с одного счёта на другой счёт:
    //если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) throws UserChecks {
        boolean result = false;
        //пользователь-источник
        try {
            User srcUser = findUserByPassport(srcPassport);
            Account srcAccount = findAccountByRequisites(bank.get(srcUser), srcRequisite);
            //пользователь-получатель
            User destUser = findUserByPassport(destPassport);
            Account destAccount = findAccountByRequisites(bank.get(destUser), destRequisite);
            //если получается изменить баланс и он не отрицательный - переводим деньги по назначению
            if (srcAccount != null & destAccount != null & srcAccount.setValue(srcAccount.getValue() - amount)) {
                result = destAccount.setValue(destAccount.getValue() + amount);
            }
            return result;
        } catch (UserChecks uc) {
            System.out.println("Пользователь не найден");
        }
        return result;
    }
}
