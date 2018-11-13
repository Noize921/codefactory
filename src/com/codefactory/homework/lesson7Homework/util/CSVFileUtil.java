package com.codefactory.homework.lesson7Homework.util;

import java.io.File;

public class CSVFileUtil {
    public static boolean fileExists(String fileName) {
        File file = null;

        try {
            file = new File(fileName);
            return file.exists();
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }
}
