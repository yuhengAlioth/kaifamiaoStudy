package Code.ioDemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：FileWriterDemo
 * @代码功能：字符输出流
 * @时间：2023/09/14/17:16
 */
public class FileWriterDemo {
    public static void main(String[] args) {
        // 使用默认字符集构建一个字符输出流 新创建对象的是在原有的拼接还是不拼接
        try {
            FileWriter writer = new FileWriter(new File("D:\\桌面\\intTest.txt"));
            FileWriter writer1 = new FileWriter(new File("D:\\桌面\\intTest.txt"), Charset.forName("GBK"));
            writer.write("遥遥领先");
            writer.write("有点不一样");
////            writer1.write("遥遥领先", 1, 2); // 从字符串下标为1 的地方开始往出写，写2位
//            char[] charArray = "让编程变简单，让学习变快乐".toCharArray();
////            writer1.write(charArray);
//            writer1.write(charArray, 7, 6); // 从字符数组下标为7的地方开始往出写，写6位

//            System.out.println(writer.getEncoding()); // UTF8
//            System.out.println(writer1.getEncoding()); // GBK

            writer.write("轻舟已过万重山");
//            writer.write("一夫当关万夫莫开");
            writer.append("一夫当关万夫莫开"); // 将字符序列拼接到该输出流

            writer.flush(); // 字符输出流写完东西一定要记得关闭或者刷新流
//            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

