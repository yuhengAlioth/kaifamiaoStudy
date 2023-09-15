package Code.ioDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：InputStreamReaderDemo
 * @代码功能：
 * @时间：2023/09/15/11:57
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        try (InputStreamReader inputStreamReader =
                     new InputStreamReader(new FileInputStream("D:\\桌面\\csb.txt"));
             InputStreamReader inputStreamReader2 =
                     new InputStreamReader(new FileInputStream("D:\\桌面\\出师表(gbk).txt"),"GBK");){

            System.out.println(inputStreamReader.getEncoding());
            System.out.println((char) inputStreamReader.read());
            System.out.println((char) inputStreamReader2.read());

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}

