package ru.job4j.department;

import ru.job4j.list.User;

import java.util.Comparator;

public class Department implements Comparable<Department> {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Department department) {
        return name.compareTo(department.getName());
    }
}
