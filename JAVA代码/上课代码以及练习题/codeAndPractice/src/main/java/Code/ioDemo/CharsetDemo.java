package Code.ioDemo;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：CharsetDemo
 * @代码功能：
 * @时间：2023/09/12/17:12
 */
public class CharsetDemo {
    public static void main(String[] args) {
        Charset gbk = Charset.forName("GBK");
        Charset utf8 = Charset.forName("UTF-8");
        System.out.println(Charset.defaultCharset()); //默认字符集
        // GBK 中 汉字占2个字节 字母占1一个字节
        // UTF-8 中 汉字占3个字节 字母占 1一个字节
        String str = "开发喵";
        String str1 = "kfm";
        byte[] bytes1 = new byte[]{97, 98, 99};
        System.out.println(new String(bytes1)); // 按照默认字符集将byte数组转成字符串
        System.out.println("====");
        byte[] bytes = str.getBytes(StandardCharsets.US_ASCII);
        byte[] bytes2 = str.getBytes(); // 按照默认字符集将字符串转成 byte数组
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);
        System.out.println(bytes.length); // 6
        System.out.println(str1.getBytes(gbk).length); // 3
        System.out.println(str.getBytes(utf8).length);
        System.out.println(str1.getBytes(utf8).length);
    }
}

