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
        int[] nums = {5, 2, 4, 6, 8, 5};
        String name = "D:\\桌面\\intTest.txt";
        File file = new File(name);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try(FileOutputStream out = new FileOutputStream(file);
            FileInputStream in = new FileInputStream(file)
        ) {
            String str = "";
            for (int num : nums) {
                str += String.valueOf(num) + ",";
            }
            str = str.substring(0, str.length() - 1);
            byte[] bytes = str.getBytes();
            out.write(bytes);
            byte[] allBytes = in.readAllBytes();
            String num = new String(allBytes);
            String[] split = num.split(",");
            int sum = 0;
            for (String s : split) {
//                System.out.println(s);
                sum += Integer.parseInt(s);
            }
            System.out.println("总和：" + sum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
