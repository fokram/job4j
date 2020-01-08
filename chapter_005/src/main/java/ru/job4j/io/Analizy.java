package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {

    private List badStatus = List.of("400", "500");
    private List goodStatus = List.of("200", "300");

    public void unavailable(String source, String target) {
        List<String> listFile = read(source);
        String problemAppear = "";

        try (FileWriter wr = new FileWriter(target)) {
                for (String line: listFile) {
                String[] str = line.split(" ");
                if (str.length == 2) {
                    if (badStatus.contains(str[0]) && problemAppear.isEmpty()) {
                        problemAppear = str[1];
                    } else if (!problemAppear.isEmpty() && goodStatus.contains((str[0]))) {
                        wr.append(problemAppear + ";" + str[1] + "\n");
                        problemAppear = "";
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> read(String path) {
        List<String> result = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            result = buffer.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("unavailable.csv")) {
            fw.append("15:01:30;15:02:32");
            fw.append("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}