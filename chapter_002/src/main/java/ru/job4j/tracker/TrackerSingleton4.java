package ru.job4j.tracker;

//private static final class. Lazy loading.
public class TrackerSingleton4 {

    private TrackerSingleton4() {
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleton4.getInstance();
    }
}