package Code.ioDemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：BufferedReaderDemo
 * @代码功能：
 * @时间：2023/09/14/17:42
 */
public class BufferedReaderDemo {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("D:\\桌面\\intTest.txt");
             BufferedReader bufferedReader = new BufferedReader(reader);) {
//            char c = (char) bufferedReader.read();
//            System.out.println(c);
//            char[] chars = new char[10];
//            String str = "";
//            int read = 0;
//            while ((read = bufferedReader.read(chars)) != -1) {
//                str += new String(chars, 0, read);
//            }
//            System.out.println(str);
//            int read = bufferedReader.read(chars);
//
//            read = bufferedReader.read(chars);
//            str += new String(chars, 0, read);
//            read = bufferedReader.read(chars);
//            if (read < 0) {
//
//            }
//            str += new String(chars, 0, read);


            String line = ""; // 读一行文本
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {

        }
    }
}

