package ru.job4j.list;

import java.util.Comparator;

class UserComparatorByNameLength implements Comparator<User> {
    public int compare(User a, User b) {
        if (a.getName().length() > b.getName().length()) {
            return 1;
        } else if (a.getName().length() < b.getName().length()) {
            return -1;
        } else {
            return 0;
        }
    }
}