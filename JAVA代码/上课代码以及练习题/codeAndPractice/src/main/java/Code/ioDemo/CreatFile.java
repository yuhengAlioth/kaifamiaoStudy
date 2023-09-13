package Code.ioDemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：CreatFile
 * @代码功能：创建文件
 * @时间：2023/09/13/14:28
 */
public class CreatFile {
    public static void main(String[] args) {
        String path = "E:/kfm/data";
        String name = "hello.txt";
        new File(path, name);
        // "/" 如果你的JVM是mac linux "/"  windows  "\\"
        new File(path + File.separator + name);

        String name1 = "E:\\test\\genshin\\yuanshen.txt";
        File file = new File(name1);
        File dest = new File("E:\\test\\genshin\\yuanshen2.txt");
        System.out.println(dest.renameTo(file));
        String pic = "E:\\Image\\time.jpg";
        String destPic = "E:\\Image\\图片\\time.jpg";
        Path path1 = new File(pic).toPath();
        Path path2 = new File(destPic).toPath();
        try {
            Files.copy(path1, path2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (file.isDirectory()) {
            file.mkdirs();
        } else {
            File parent = file.getParentFile();
            try {
                if (!parent.exists()) { // 判断上级文件夹是否存在
                    if (parent.mkdirs()) {
                        System.out.println(file.createNewFile());
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

