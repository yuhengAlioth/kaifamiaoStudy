package Code.ioDemo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：FileReaderDemo
 * @代码功能：字符输入流
 * @时间：2023/09/14/17:15
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        // 用默认的字符集获取一个字符输入流 UTF-8
        try (FileReader reader = new FileReader(new File("D:\\桌面\\intTest.txt"));
             FileReader reader1 = new FileReader(new File("D:\\桌面\\intTest.txt"), Charset.forName("GBK"))
        ) {
            int c = reader1.read();
            System.out.println((char) c);
            char[] chars = new char[20];

            int read = reader.read(chars); // 将字符读到chars中，返回实际读取的字符数
            System.out.println(new String(chars, 0, read));

//            int read = reader1.read(chars, 2, 10);
//            System.out.println(new String(chars, 2, read));

            System.out.println(reader1.markSupported()); // 是否支持mark() 方法

            // 编码格式
            System.out.println(reader.getEncoding());
            System.out.println(reader1.getEncoding());
//            reader1.mark(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

