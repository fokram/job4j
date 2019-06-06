package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<User, ArrayList<Account>> bank = new HashMap<>();

    //добавление пользователя
    public void addUser(User user) {
        bank.putIfAbsent(user, new ArrayList<>());
    }

    //удаление пользователя
    public void deleteUser(User user) {
        bank.remove(user);
    }

    //поиск пользователя в банке по паспорту
    private User findUserByPassport(String passport) {
        User result = null;
        for (User user:bank.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    //найти счет у пользователя
    private Account findAccountByRequisitesAndPassport(String requisites, String passport) {
        Account result = null;
        User user = findUserByPassport(passport);
        if (user != null) {
            for (Account account : bank.get(user)) {
                if (account.getRequisites().equals(requisites)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    //добавить счёт пользователю
    public void addAccountToUser(String passport, Account account) {
        bank.get(findUserByPassport(passport)).add(account);
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
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;
        //аккаунт-источник
        Account srcAccount = findAccountByRequisitesAndPassport(srcRequisite, srcPassport);
        //аккаунт-получатель
        Account destAccount = findAccountByRequisitesAndPassport(destRequisite, destPassport);
        //если получается изменить баланс и он не отрицательный - переводим деньги по назначению
        if (srcAccount != null && destAccount != null && srcAccount.setValue(srcAccount.getValue() - amount)) {
            result = destAccount.setValue(destAccount.getValue() + amount);
        }
        return result;
    }
}
