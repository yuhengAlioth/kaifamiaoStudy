package Practice.LX0919;

import Practice.LX0908.Exec02;

import java.io.*;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0919
 * @文件名称：File
 * @代码功能：批量处理大文件
 * @时间：2023/09/20/11:38
 */
public class File {
    public static void main(String[] args) {
        // 编写一个多线程程序，可以并行处理大量文本文件。每个线程负责读取一个文件，进行处理，然后将结果
        // 写入输出文件。
        String fileName = "io";
        String destName = "io\\tjw.txt";
        dx(fileName, destName);
    }


    public static void dx(String fileName, String destName) {
        java.io.File file = new java.io.File(fileName);
        // 获取目标目录下所有文件
        java.io.File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(java.io.File f) {
                return f.isFile() && f.getName().endsWith(".txt");
            }
        });
        for (java.io.File f : files) {
            new Thread(() -> {
                synchronized (Exec02.class) {
                    try (FileInputStream in = new FileInputStream(f);
                         FileOutputStream out = new FileOutputStream(new java.io.File(destName), true);) {
                        byte[] bytes = in.readAllBytes(); // 编码格式修改
                        String str = new String(bytes, "UTF-8");
                        out.write(str.getBytes("GBK"));
                        // in.transferTo(out);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}

