package ru.job4j.statistic;

import java.util.List;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info result = new Info();
        //deleted and/or changed
        for (User userPrevious : previous) {
            boolean founded = false;
            for (User userCurrent : current) {
                if (userPrevious.getId() == userCurrent.getId()) {
                    founded = true;
                    if (userPrevious.getName() != userCurrent.getName()) {
                        result.changed++;
                    }
                    break;
                }
            }
            if (!founded) {
                result.deleted++;
            }
        }

        for (User userCurrent : current) {
            boolean founded = false;
            for (User userPrevious : previous) {
                if (userPrevious.getId() == userCurrent.getId()) {
                    founded = true;
                    break;
                }
            }
            if (!founded) {
                result.added++;
            }
        }
        return result;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;
        public Info() {
            this.added = 0;
            this.changed = 0;
            this.deleted = 0;
        }
        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }

}