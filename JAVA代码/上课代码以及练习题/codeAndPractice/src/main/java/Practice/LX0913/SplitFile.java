package Practice.LX0913;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0913
 * @文件名称：SplitFile
 * @代码功能：将大文件拆分成多个小文件，每个小文件的大小可以自定义，这样可以方便传输，也可以方便存储
 * @时间：2023/09/13/19:06
 */
public class SplitFile {
    public static void main(String[] args) {
        String target = "C:\\Users\\15322\\Videos\\Captures\\无尘视频.mp4";
        String dest = "C:\\Users\\15322\\Videos\\Captures\\copy";
//        split(target,dest,1024 * 512);
        split2(target,dest,1024 * 512);
    }

    private static void split(String target,String dest,long size){
        File targetFile = new File(target);
        File destFile = new File(dest);
        if (!targetFile.exists()){
            throw new RuntimeException("该目录下没有这个文件");
        }
        // 判断目录是否存在
        if (!destFile.exists()){
            destFile.mkdirs();
        }
        try (FileInputStream in = new FileInputStream(target)){
            int count = 1;
            byte[] bytes = new byte[(int) size]; // 每次取传入的字节大小内容放进byte[]
            while (true){
                int readSize = in.read(bytes); // 读出拿到的字节的长度
                if (readSize <= 0){
                    break; // 最后一个文件直接退出
                }
                FileOutputStream out = new FileOutputStream(new File(dest, count + ".aliothstar")); // 给分割的文件重新命名
                out.write(bytes,0,readSize); // 将byte[]的数据写入到新目录的文件里面
                out.flush();
                out.close();
                count ++;
            }
            System.out.println("文件分割完成");
            System.out.println("文件分割为：" + (count - 1) + "个");
        }catch (IOException  e){
            throw new RuntimeException(e);
        }
    }

    private static void split2(String target,String dest,long size){
        File targetFile = new File(target);
        File destFile = new File(dest);
        if (!targetFile.exists()){
            throw new RuntimeException("该目录下没有这个文件");
        }
        // 判断目录是否存在
        if (!destFile.exists()){
            destFile.mkdirs();
        }
        try (FileInputStream in = new FileInputStream(target)){
            int count = 1;
            while (in.available() > 0){
                if (size > Integer.MIN_VALUE - 8){ // 数组最大的长度
                    long sum = size;
                    try (FileOutputStream out = new FileOutputStream(new File(dest, count + ".aliothstar"),true);){
                        while (sum > Integer.MIN_VALUE - 8 && in.available() > 0){
                            byte[] bytes = new byte[Integer.MIN_VALUE - 8];
                            int readSize = in.read(bytes); // 读出拿到的字节的长度
                            out.write(bytes,0,readSize); // 将byte[]的数据写入到新目录的文件里面
                            sum -= readSize; // 减去这次分割的长度后剩下的长度
                            count ++;
                        }
                        if (in.available() > 0) { // 最后一次的size位还没读完
                            byte[] bytes = new byte[(int) sum];
                            int readSize = in.read(bytes);
                            out.write(bytes, 0, readSize);
                            count ++;
                        }  // 从输入流in里面读取 size长度的字节到输出流 out
                    }
                }else {
                    byte[] bytes = new byte[(int) size]; // 每次取传入的字节大小内容放进byte[]
                    try (FileOutputStream out = new FileOutputStream(new File(dest, count + ".aliothstar"),true);){
                        int readSize = in.read(bytes); // 读出拿到的字节的长度
                        out.write(bytes,0,readSize); // 将byte[]的数据写入到新目录的文件里面
                        count ++;
                    }
                }
            }
            System.out.println("文件分割完成");
            System.out.println("文件分割为：" + (count - 1) + "个");
        }catch (IOException  e){
            throw new RuntimeException(e);
        }
    }
}

