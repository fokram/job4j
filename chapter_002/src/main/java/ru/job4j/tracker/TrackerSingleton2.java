package ru.job4j.tracker;

//static field. Lazy loading.
public class TrackerSingleton2 {
    private static Tracker instance;

    private TrackerSingleton2() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}