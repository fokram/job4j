package ru.job4j.list;

import java.util.Comparator;

class UserComparatorByAge implements Comparator<User> {
    public int compare(User a, User b) {
        if (a.getAge() > b.getAge()) {
            return 1;
        } else if (a.getAge() < b.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
}
