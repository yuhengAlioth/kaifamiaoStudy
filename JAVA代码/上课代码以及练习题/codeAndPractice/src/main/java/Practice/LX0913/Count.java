package Practice.LX0913;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0913
 * @文件名称：Count
 * @代码功能：使用字节输出流将一组整数写入到文件中，并使用字节输入流读取这些整数并计算它们的总和
 * @时间：2023/09/13/17:29
 */
public class Count {
    public static void main(String[] args) {
        int[] num = {5, 2, 4, 6, 8, 5};
        String txt = "D:\\桌面\\intTest.txt";
        // 写入整数到文件..
        try (FileOutputStream out = new FileOutputStream(txt)) {
            for (int i : num) {
                out.write(i);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 读取计算
        int sum = 0;
        try (FileInputStream in = new FileInputStream(txt)) {
            int value;
            while ((value = in.read()) != -1) {
                int number = value;
                sum += number;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("总和：" + sum);
    }
}
