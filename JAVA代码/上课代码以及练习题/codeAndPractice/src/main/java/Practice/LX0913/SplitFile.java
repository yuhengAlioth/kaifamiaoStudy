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
        split(target,1024 * 512,dest);
    }

    private static void split(String target,long size ,String dest){
        File file = new File(dest);
        // 判断目录是否存在
        if (!file.exists()){
            file.mkdirs();
        }
        try (FileInputStream in =new FileInputStream(target)){
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
            System.out.println("文件分割完成。");
        }catch (IOException  e){
            throw new RuntimeException(e);
        }
    }
}

