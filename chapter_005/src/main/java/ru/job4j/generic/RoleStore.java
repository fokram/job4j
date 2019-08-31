package ru.job4j.generic;

import ru.job4j.iterators.SimpleArray;

import java.util.NoSuchElementException;

public class RoleStore implements Store<Role> {
    SimpleArray<Role> sa;

    public RoleStore(int sizeArray) {
        this.sa = new SimpleArray(sizeArray);
    }

    public void add(Role role) {
        this.sa.add(role);
    }

    private int getArrayIndex(String id) {
        int result = -1;
        int idx = 0;
        while (idx < sa.getLength()) {
            if (sa.get(idx).getId() == id) {
                result = idx;
                break;
            }
            idx++;
        }
        if (result == -1) {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public boolean replace(String id, Role model) {
        return sa.set(getArrayIndex(id), model);
    }

    @Override
    public Role findById(String id) {
        return sa.get(getArrayIndex(id));
    }

    @Override
    public boolean remove(String id) {
        return sa.remove(getArrayIndex(id));
    }
}
