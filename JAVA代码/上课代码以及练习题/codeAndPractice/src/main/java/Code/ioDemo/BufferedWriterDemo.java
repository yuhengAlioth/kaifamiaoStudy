package Code.ioDemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：BufferedWriterDemo
 * @代码功能：
 * @时间：2023/09/14/17:43
 */
public class BufferedWriterDemo {
    public static void main(String[] args) {
        try (FileWriter fileWriter = new FileWriter("D:\\桌面\\intTest.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            bufferedWriter.write("白日依山尽\r\n");
            bufferedWriter.newLine(); // 换行
            bufferedWriter.write("黄河入海流\r\n");
            bufferedWriter.write("欲穷千里目\n");
            bufferedWriter.write("更上一层楼\n");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

