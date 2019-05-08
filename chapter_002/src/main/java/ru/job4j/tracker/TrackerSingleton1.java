package ru.job4j.tracker;

//enum. Eager loading.
public enum TrackerSingleton1 {
    INSTANCE;
    public Tracker tracker = new Tracker();
}