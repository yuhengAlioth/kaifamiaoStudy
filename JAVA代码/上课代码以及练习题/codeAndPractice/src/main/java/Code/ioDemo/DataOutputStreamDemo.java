package Code.ioDemo;

import java.io.*;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：DataOutputStreamDemo
 * @代码功能：
 * @时间：2023/09/15/12:08
 */
public class DataOutputStreamDemo {
    public static void main(String[] args) {
        // 数据输出流
        try (DataOutputStream data = new DataOutputStream(
                new FileOutputStream("D:\\桌面\\data.txt"));
             DataInputStream in = new DataInputStream(new FileInputStream("D:\\桌面\\data.txt"))
        ) {
            data.writeBoolean(true); // 1
            data.writeDouble(2.3); // 8
            data.writeByte(1); // 1
            data.writeChars("国庆快乐");
            data.writeUTF("十一快乐");
            boolean b = in.readBoolean();
            byte i = in.readByte();
            double v = in.readDouble();
            System.out.println(b);
            System.out.println(v);
            System.out.println(i);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

