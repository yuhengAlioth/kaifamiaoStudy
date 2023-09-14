package Code.ioDemo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：BufferedInputStreamDemo
 * @代码功能：文件输入流
 * @时间：2023/09/14/17:25
 */
public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream(new File("D:\\桌面\\intTest.txt"));
             // 用字节输入缓存流包装字节输入流 底层有一个存储字节的数组：buf 默认长度是 8192
             BufferedInputStream bufferedInputStream = new BufferedInputStream(in);) {
            System.out.println(bufferedInputStream.available());
            System.out.println(bufferedInputStream.markSupported()); // 支持mark()

            byte[] bytes = new byte[3];
            int read = bufferedInputStream.read(bytes);
            System.out.println("第一个内容：" + new String(bytes));

            // readlimit: 在当前标记之后再读取 Math.max(readlimit, size) 个字节，标记就失效了
            bufferedInputStream.mark(2); // 当前流的位置标记  2 底层缓存数组 的较大值

//            bytes = new byte[8192];

            read = bufferedInputStream.read(bytes);
            System.out.println("第二个内容：" + new String(bytes));

            bufferedInputStream.reset();

            read = bufferedInputStream.read(bytes);
            System.out.println("第三个内容：" + new String(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

