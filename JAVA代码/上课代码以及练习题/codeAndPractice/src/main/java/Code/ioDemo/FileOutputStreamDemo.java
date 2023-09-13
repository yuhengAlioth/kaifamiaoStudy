package Code.ioDemo;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：FileOutputStreamDemo
 * @代码功能：输出流
 * @时间：2023/09/13/16:38
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) {
        try {
            // 如果文件不存在会自动创建
            // 第二个参数代表是否拼接
            FileOutputStream out = new FileOutputStream("D:\\桌面\\winrar破解方法.md",true);
            out.write(120); // 一次写入一个
            byte[] bytes = new byte[]{99,105,97};
            byte[] bytes1 = "华为 遥遥领先".getBytes();
            out.write(bytes1);
//            out.write(bytes, 1, 2); // 一些写bytes个字节 从byte的下标为1的地方开始写，写2位
            out.flush();
            out.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}

