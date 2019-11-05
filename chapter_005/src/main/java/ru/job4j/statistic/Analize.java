package ru.job4j.statistic;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info result = new Info();

        Map<Integer, String> prevMap = previous
                .stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        Map<Integer, String> currMap = current
                .stream()
                .collect(Collectors.toMap(User::getId, User::getName));

        //deleted and/or changed
        for (User userPrevious : previous) {
            if (currMap.containsKey(userPrevious.id)) {
                if (!userPrevious.name.equals(currMap.get(userPrevious.id))) {
                    result.changed++;
                }
            } else {
                result.deleted++;
            }
        }

        //added
        for (User userCurrent : current) {
            if (!prevMap.containsKey(userCurrent.id)) {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
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