package ru.job4j.tracker;

//static final field. Eager loading.
public class TrackerSingleton3 {
    private static Tracker instance = new Tracker();

    private TrackerSingleton3() {
    }

    public static Tracker getInstance() {
        return instance;
    }
}