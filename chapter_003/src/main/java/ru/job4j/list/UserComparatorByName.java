package ru.job4j.list;

import java.util.Comparator;

class UserComparatorByName implements Comparator<User> {
    public int compare(User a, User b) {
        return a.getName().compareTo(b.getName());
    }
}
