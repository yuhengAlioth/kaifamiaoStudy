package Code.XianCheng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.XianCheng
 * @文件名称：SlitFile
 * @代码功能：
 * @时间：2023/09/19/15:30
 */
public class SplitFile {
    public static void main(String[] args) {
        String target = "C:\\Users\\15322\\Videos\\Captures\\无尘视频.mp4";
        String dest = "C:\\Users\\15322\\Videos\\Captures\\copy";
//        split(target, dest, 1024 * 512);
    }

    private static void split(String target, String dest, long size) {
        File targetFile = new File(target);
        File destFile = new File(dest);
        if (!targetFile.exists()) {
            throw new RuntimeException("该目录下没有这个文件");
        }
        // 判断目录是否存在
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        try (FileInputStream in = new FileInputStream(target)) {
            int count = 1;
            byte[] bytes = new byte[(int) size]; // 每次取传入的字节大小内容放进byte[]
            while (true) {
                int readSize = in.read(bytes); // 读出拿到的字节的长度
                if (readSize <= 0) {
                    break; // 最后一个文件直接退出
                }
                FileOutputStream out = new FileOutputStream(new File(dest, count + ".aliothstar")); // 给分割的文件重新命名
                out.write(bytes, 0, readSize); // 将byte[]的数据写入到新目录的文件里面
                out.flush();
                out.close();
                count++;
            }
            System.out.println("文件分割完成");
            System.out.println("文件分割为：" + (count - 1) + "个");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


