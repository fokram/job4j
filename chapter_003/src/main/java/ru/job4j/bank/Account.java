package ru.job4j.bank;

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

    public boolean setValue(double value) {
        boolean result = false;
        if (value >= 0) {
            this.value = value;
            result = true;
        }
        return result;
    }

    public String getRequisites() {
        return requisites;
    }
}
