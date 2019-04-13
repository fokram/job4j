package ru.job4j.tracker;

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
}