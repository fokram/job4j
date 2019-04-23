package ru.job4j.tracker;

import java.util.List;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }
    public String ask(String question) {
        return this.input.ask(question);
    }
    public int ask(String question, List<Integer> range) {
        int answer = -1;
        boolean gotIt = false;
        do {
            try {
                answer = input.ask(question, range);
                gotIt = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only menu point in number.");
            } catch (MenuOutException moe) {
                System.out.println(moe.getMessage());
            }
        } while (!gotIt);
        return answer;
    }
}