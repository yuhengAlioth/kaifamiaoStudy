package Practice.LX0914;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0914
 * @文件名称：Transform
 * @代码功能：将一个UTF-8编码的文件转换成一个GBK格式的文件
 * @时间：2023/09/14/20:10
 */
public class Transform {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();

        try (FileReader reader = new FileReader(new File("io\\出师表.txt"));
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter writer = new FileWriter(new File("io\\出师表(gbk).txt"), Charset.forName("GBK"));
             BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            String line = ""; // 读一行文本
            while ((line = bufferedReader.readLine()) != null) {
                String modifiedLine = line.replace("。", "。\n");
                stringList.add(modifiedLine);
            }
            // 编码格式
            System.out.println(reader.getEncoding());
            for (String s : stringList) {
                bufferedWriter.write(s);
                bufferedWriter.newLine(); // 换行
                writer.flush(); // 字符输出流写完东西一定要记得关闭或者刷新流
            }
            // 编码格式
            System.out.println(writer.getEncoding());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

