package com.utils.proguard;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class Utils {

    private char[] chars;
    private String fileName;
    private int len;
    private List<String> list = new ArrayList<>();

    public static void main(String[] args) {
//        new Utils("proguard-o0O.txt", '0', 'o', 'O', '8', '〇').start();
//        new Utils("proguard-1il.txt", '1', 'i', 'l', 'L', 'I', '丨').start();
//        new Utils("proguard-socialism.txt", "富强民主文明和谐自由平等公正法治爱国敬业诚信友善".toCharArray()).start();

        new Utils("proguard-o0O.txt", '0', 'o', 'O', '8', '〇', '丨','1', 'i', 'l', 'L', 'I').start();
    }


    /**
     * @param fileName 文件名
     * @param chars    混淆字符
     */
    public Utils(String fileName, char... chars) {
        this.chars = chars;
        this.fileName = fileName;
        len = Math.max(8, (int) (Math.log(8000) / Math.log(chars.length) * 1.5));
        System.out.println("max length：" + len);
    }

    public void start() {
        for (int i = 0; i < 8000; i++) {
            int len = (int) (2 + Math.random() * this.len);
            StringBuilder k = new StringBuilder();
            for (int i1 = 0; i1 < len; i1++) {
                k.append(randomChar(i1 == 0));
            }
            String s = k.toString();
            if (list.contains(s)) {
                i--;
                continue;
            }
            list.add(s);
            writeFile(fileName, s);
        }
    }

    private char randomChar(boolean firstChar) {
        char aChar = chars[(int) (Math.random() * chars.length)];
        if (firstChar && (aChar >= '0' && aChar <= '9')) {
            return randomChar(firstChar);
        }
        return aChar;
    }


    public static void writeFile(String file, String content) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            out.write(content + "\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
