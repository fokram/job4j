package ru.job4j.tur;

import org.junit.Test;

import java.util.List;

public class ProfilesTest {
    @Test
    public void getClassesList() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Alyabina", 1, 1)),
                new Profile(new Address("St.Peterburg", "Beef", 2, 35)),
                new Profile(new Address("Novgorod", "Camel", 5, 111)),
                new Profile(new Address("Ekaterinburg", "Dock", 2, 35)),
                new Profile(new Address("Ekaterinburg", "Dock", 2, 35)),
                new Profile(new Address("Abakan", "Jacks", 2, 35))
        );
        (new Profiles().collect(profiles)).forEach(System.out::println);
    }
}