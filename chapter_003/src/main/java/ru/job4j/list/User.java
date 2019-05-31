package ru.job4j.list;

public class User implements Comparable<User> {

    private int id;
    private String name;
    private String city;
    private Integer age;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(User user) {
        return age.compareTo(user.getAge());
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public String getCity() {
        return city;
    }
}
