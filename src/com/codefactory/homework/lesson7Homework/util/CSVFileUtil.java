package com.codefactory.homework.lesson7Homework.util;

import java.io.File;

public class CSVFileUtil {
    public static boolean fileExists(String fileName) {
        return new File(fileName).exists();
    }
}
