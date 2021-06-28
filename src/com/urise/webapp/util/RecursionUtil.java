package com.urise.webapp.util;

import java.io.File;
import java.util.Objects;

//Базис рекурсии: String path (директория basejava)
//Точка выхода из рекурсии: окончание цикла for (проход по файлам и директориям basejava)
public class RecursionUtil {
    private static StringBuilder tab = new StringBuilder("");

    public static void pathOutput(String path) {
        File[] catalog = new File(path).listFiles();

        for (File file : Objects.requireNonNull(catalog)) {
            System.out.print(tab.toString());
            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                System.out.println(file.getName());
                tab.append("\t");
                pathOutput(path + File.separator + file.getName());
                tab.delete(tab.length() - 1, tab.length());
            }
        }
    }

    public static void main(String[] args) {
        com.urise.webapp.util.RecursionUtil.pathOutput("..\\baseJava\\src\\");
    }
}