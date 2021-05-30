package com.urise.webapp.util;

import java.io.File;
import java.util.Objects;

//Базис рекурсии: String path (директория basejava)
//Точка выхода из рекурсии: окончание цикла for (проход по файлам и директориям basejava)
public class RecursionUtil {
    public static void pathOutput(String path) {
        File root = new File(path);
        File[] catalog = root.listFiles();
        for (File file : Objects.requireNonNull(catalog)) {
            if (file.isFile()) {
                System.out.println("\t" + file.getName());
            } else if(file.isDirectory()){
                System.out.println(file.getName());
                pathOutput(path + File.separator + file.getName());
            }
        }
    }

    public static void main(String[] args) {
        com.urise.webapp.util.RecursionUtil.pathOutput("..\\baseJava\\src\\");
    }
}