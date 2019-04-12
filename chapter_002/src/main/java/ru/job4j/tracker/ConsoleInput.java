package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    public String ask(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.nextLine();
    }
}