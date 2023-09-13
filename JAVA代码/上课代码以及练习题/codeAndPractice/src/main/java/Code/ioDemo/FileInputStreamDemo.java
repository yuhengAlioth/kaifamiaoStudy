package Code.ioDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：FileInputStreamDemo
 * @代码功能：输入流
 * @时间：2023/09/13/16:37
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("E:\\KFM\\test\\001.txt");
            int available = in.available(); // 当前流的所有字节数
            System.out.println("可用字节数" + available);
//            int b = in.read();  // 获取字节字节 然后返回
//            System.out.println(b);
            byte[] bytes = new byte[10];
//            int size = in.read(bytes); // 将字节读到bytes数组中，返回实际读取的字节数 (-1 - bytes.length)
            int size = in.read(bytes, 2, 8); // 字节读到bytes数组，从数组的下标为2的地方开始放，最多只读6位只读
            System.out.println(Arrays.toString(bytes));
//            // 将byte数组转换成字符串  new String()
            System.out.println(new String(bytes, 2, size));
            System.out.println(size);
            System.out.println(in.available()); // 0
            byte[] bytes1 = in.readAllBytes();
            System.out.println(new String(bytes1)); // 空的
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

