package Code.ioDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：OutputStreamWriterDemo
 * @代码功能：
 * @时间：2023/09/15/12:02
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        // 字符输出流默认是 GBK输出
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("D:\\桌面\\abc.txt"),"UTF-8")){

            System.out.println(outputStreamWriter.getEncoding());
            outputStreamWriter.write("抢不到票" + System.lineSeparator());
            outputStreamWriter.write("麻麻地" + System.lineSeparator());

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}

