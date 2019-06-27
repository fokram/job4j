package ru.job4j.tur;

import org.junit.Test;

import java.util.List;

public class ProfilesTest {
    @Test
    public void getClassesList() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Lyubanka", 1, 1)),
                new Profile(new Address("St.Peterburg", "Nevskiy", 2, 35)),
                new Profile(new Address("Novgorod", "fghjm", 5, 111)),
                new Profile(new Address("Ekaterinburg", ";lokj", 2, 35))
        );
        (new Profiles().collect(profiles)).forEach(System.out::println);
    }
}
