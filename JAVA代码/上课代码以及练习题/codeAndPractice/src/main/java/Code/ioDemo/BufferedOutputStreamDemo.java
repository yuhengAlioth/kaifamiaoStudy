package Code.ioDemo;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：BufferedOutputStreamDemo
 * @代码功能：字符输出流
 * @时间：2023/09/14/17:40
 */
public class BufferedOutputStreamDemo {
    public static void main(String[] args) {
        // file name  file append  name append
        try (FileOutputStream out = new FileOutputStream("D:\\桌面\\intTest.txt");
             BufferedOutputStream outputStream = new BufferedOutputStream(out);) {
            outputStream.write(97);
            byte[] bytes = "鹅鹅鹅".getBytes();
            outputStream.write(bytes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

