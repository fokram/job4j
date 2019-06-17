package ru.job4j.department;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortDepartmentTest {
    SortDepartment sd = new SortDepartment();
    @Before
    public void pre () {
        sd.add("K1\\SK1");
        sd.add("K1\\SK2");
        sd.add("K1\\SK1\\SSK1");
        sd.add("K1\\SK1\\SSK2");
        sd.add("K2");
        sd.add("K2\\SK1\\SSK1");
        sd.add("K2\\SK1\\SSK2");
    }
    @Test
    public void whenAddDesc() {
        TreeSet<Department> ts = new TreeSet<> (sd.departmentComparatorDesc);
        ts.addAll(sd.getDepartmetns());
        int result = 1;
        String[] expectedList = {"K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"};
        int i = 0;
        for (Department dept : ts) {
            if (!dept.getName().equals(expectedList[i++])) {
                result = 0;
                break;
            }
        }
        assertThat(result, is(1));
    }
    @Test
    public void whenAddAsc() {
        int result = 1;
        String[] expectedList = {"K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"};
        int i = 0;
        for (Department dept : sd.getDepartmetns()) {
            if (!dept.getName().equals(expectedList[i++])) {
                result = 0;
                break;
            }
        }
        assertThat(result, is(1));
    }
}
