package com.jeejio.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public  static List<String> readFileByLine(String file) throws IOException {
        ArrayList<String> arrayList = new ArrayList<String>();
        InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(file);
        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader bf = new BufferedReader(inputReader);
        // 按行读取字符串
        String str;
        while ((str = bf.readLine()) != null) {
            arrayList.add(str);
        }
        bf.close();
        inputReader.close();
        return arrayList;
    }
}
