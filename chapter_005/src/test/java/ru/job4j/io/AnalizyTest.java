package ru.job4j.io;

import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void whenAnalizeThenGetOutFile() {
        String src = "log.csv";
        String trg = "unavailable.csv";

        Analizy a = new Analizy();
        FileWriter wr = null;
        try {
            wr = new FileWriter(src);
            wr.write("200 10:56:01\n"
                    + "500 10:57:01\n"
                    + "400 10:58:01\n"
                    + "200 10:59:01\n"
                    + "500 11:01:02\n"
                    + "200 11:02:02");
            wr.close();
            a.unavailable(src, trg);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                wr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedReader logFile = null;
        try {
            logFile = new BufferedReader(new FileReader(trg));
            List<String> logList = logFile.lines().collect(Collectors.toList());
            assertThat(logList.get(0), is("10:57:01;10:59:01"));
            assertThat(logList.get(1), is("11:01:02;11:02:02"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                logFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}