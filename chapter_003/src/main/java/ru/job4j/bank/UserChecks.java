package ru.job4j.bank;

public class UserChecks extends RuntimeException {
    public UserChecks(String msg) {
        super(msg);
    }
}
