package ru.job4j.tracker;

import java.util.List;

public class ValidateInput extends ConsoleInput {

    public int ask(String question, List<Integer> range) {
        int answer = -1;
        boolean gotIt = false;
        do {
            try {
                answer = super.ask(question, range);
                gotIt = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only menu point in number");
            } catch (MenuOutException moe) {
                System.out.println("Please enter only menu point in number");
            }
        } while (!gotIt);
        return answer;
    }
}