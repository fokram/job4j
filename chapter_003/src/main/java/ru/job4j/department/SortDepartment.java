package ru.job4j.department;

import ru.job4j.list.User;

import java.util.*;

public class SortDepartment {

    private Set<Department> departmetns = new TreeSet();

    private void add(Department dept) {
        departmetns.add(dept);
    }

    public Set<Department> getDepartmetns() {
        return departmetns;
    }

    public void add(String dept) {
        int lastIndex;
        do {
            Department d = new Department(dept);
            add(d);
            lastIndex = dept.lastIndexOf("\\");
            dept = (lastIndex == -1 ? "" : dept.substring(0, lastIndex));
        } while (dept.length() != 0);
    }

    Comparator departmentComparatorDesc = new Comparator<Department>() {
        @Override
        public int compare(Department a, Department b) {
            String[] first = a.getName().split("\\\\");
            String[] second = b.getName().split("\\\\");
            int result = 0;
            for (int i = 0; i < Math.min(first.length, second.length); i++) {
                result = second[i].compareTo(first[i]);
                if (result != 0) {
                    break;
                }
            }
            //если сравнили все элементы одинакового уровня вложенности и больше сравнивать нечего - остается только сравнить
            // в каком массиве вложенность больше, тот должен идти ниже по списку отображения
            if (result == 0) {
                result = ((Integer) first.length).compareTo((Integer) second.length);
            }
            return result;
        }
    };
}