package Code.ioDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：InputStreamDemo
 * @代码功能：输入流
 * @时间：2023/09/13/12:03
 */
public class InputStreamDemo {
    public static void main(String[] args) {
        File file = new File("D:\\桌面\\winrar破解方法.md");
//        File file = new File("D:\\biancheng\\java\\jdk-17.0.2\\lib\\src.zip!\\java.base\\java\\io\\FileInputStream.java");
        try {
            FileInputStream in = new FileInputStream(file);
            int size = 0;
            byte[] bytes = new byte[10];
            String str = "";
            while ((size = in.read(bytes)) != -1){  // 一次读10个字节 返回实际读取的字节数
                str += new String(bytes,0,size);
            }
            System.out.println(str);
            in.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("===========");
        try {
            // 字节输入流
            FileInputStream in = new FileInputStream(file);
            // 一个汉字占3个字节，
            byte[] bytes = in.readAllBytes();
            System.out.println(new String(bytes));
            in.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

