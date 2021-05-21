package com.urise.webapp.util;

import java.io.File;
import java.util.Objects;

//Базис рекурсии: String path (директория basejava)
//Точка выхода из рекурсии: окончание цикла for (проход по файлам и директориям basejava)
public class RecursionUtil {
    public static void pathOutput(String path) {
        File root = new File(path);
        String[] catalog = root.list();
        for (String s : Objects.requireNonNull(catalog)) {
            File file = new File(path + File.separator + s);
            if (file.isFile()) {
                System.out.println(path + File.separator + s);
            } else {
                pathOutput(path + File.separator + s);
            }
        }
    }
}