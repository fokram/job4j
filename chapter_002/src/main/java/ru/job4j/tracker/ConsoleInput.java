package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

/**
 * @version 1
 * @since 12.04.2019
 */
public class ConsoleInput implements Input {

    /**
     * Метод задай вопрос - дождись ответа
     * @param question вопрос.
     *
     */
    public String ask(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.nextLine();
    }
    public int ask(String question, List<Integer> range) throws MenuOutException {
        int answer = Integer.valueOf(ask(question));
        boolean isInMenu = false;
        for (int val : range) {
            if (answer == val) {
                isInMenu = true;
                break;
            }
        }
        if (!isInMenu) {
            throw new MenuOutException("Out of menu range.");
        }
        return answer;
    }
}