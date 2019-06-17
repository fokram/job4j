package ru.job4j.bank;

import java.util.Collections;

public class Account {

    private double value;
    private String requisites;

    Account(String requisites, double value) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean transfer(Account destAccount, double amount) {
        boolean result = false;
        if (this.getValue() - amount >= 0) {
            this.setValue(this.getValue() - amount);
            destAccount.setValue(destAccount.getValue() + amount);
            result = true;
        }
        return result;
    }
    public String getRequisites() {
        return requisites;
    }
}