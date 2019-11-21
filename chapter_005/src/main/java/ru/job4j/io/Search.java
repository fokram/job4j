package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search {
    List<File> files(String parent, List<String> exts) {
        List<File> filesTree = null;
        List<File> result = new ArrayList<>();
        int nextForCheck = 0;
        filesTree = new ArrayList<>(Arrays.asList(new File(parent).listFiles()));
        while (nextForCheck < filesTree.size()) {
            File f = filesTree.get(nextForCheck);
            if (!f.isDirectory()) { //если это не директория - нужно проверить расширение файла, если искомое - отложить
                String fileName = f.getName();
                String extFileName = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (exts.contains(extFileName)) {
                    result.add(f);
                }
            } else { //если дирректория - нужно добавить её parents в конец
                List<File> fff = new ArrayList<>(Arrays.asList(f.listFiles()));
                filesTree.addAll(fff);
            }
            nextForCheck++;
        }
        return result;
    }
}
