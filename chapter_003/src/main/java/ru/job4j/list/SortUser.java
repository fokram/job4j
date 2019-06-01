package ru.job4j.list;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    public List<User> sortNameLength(List<User> users) {
        Comparator userComparatorByNameLength = new Comparator<User>() {
            @Override
            public int compare(User a, User b) {
                Integer first = a.getName().length();
                Integer second = b.getName().length();
                return first.compareTo(second);
            }
        };
//        Comparator<User> userComparator = new UserComparatorByNameLength();
        List<User> result = new ArrayList(users);
        result.sort(userComparatorByNameLength);
        return result;
    }

    public List<User> sortByAllFields(List<User> users) {
        Comparator userComparatorByName = new Comparator<User>() {
            @Override
            public int compare(User a, User b) {
                return a.getName().compareTo(b.getName());
            }
        };
        Comparator userComparatorByAge = new Comparator<User>() {
            @Override
            public int compare(User a, User b) {
                return a.getAge().compareTo(b.getAge());
            }
        };
        Comparator<User> userComparator = userComparatorByAge.thenComparing(userComparatorByName);
        List<User> result = new ArrayList<>(users);
        result.sort(userComparator);
        return result;

    }
}
