package Practice.LX0913;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;


/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0913
 * @文件名称：MergeFile
 * @代码功能：将多个小文件合并成一个大文件，这样可以方便存储，也可以方便传输
 * @时间：2023/09/13/19:43
 */
public class MergeFile {
    public static void main(String[] args) {
        String dest = "C:\\Users\\15322\\Videos\\Captures\\copy"; // 分割文件所在目录
        String target = "C:\\Users\\15322\\Videos\\Captures\\copy\\合并视频.mp4"; // 合并后的文件路径和名称

        merge(dest, target);
    }

    private static void merge(String dest, String target) {
        File targetFile = new File(target);
        if (!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }

        File destFile = new File(dest);
        File[] files = destFile.listFiles((destFile1, name) -> name.endsWith(".aliothstar")); // 获取目录中的所有文件
        System.out.println("要合并的文件数量：" + files.length + "个");

        if (files.length == 0) {
            System.out.println("没有要合成的文件");
        } else {
            // 按文件名称顺序排序
            Arrays.sort(files, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    String string1 = o1.getName();
                    String string2 = o2.getName();
                    int index1 = Integer.parseInt(string1.split("\\.")[0]);
                    int index2 = Integer.parseInt(string2.split("\\.")[0]);
                    return index1 - index2;
                }
            });
            // 简写
            Arrays.sort(files, (f1, f2) -> {
                int index1 = Integer.parseInt(f1.getName().split("\\.")[0]);
                int index2 = Integer.parseInt(f2.getName().split("\\.")[0]);
                return index1 - index2;
            });

            try (FileOutputStream out = new FileOutputStream(target);) {
                for (File file : files) {
                    try (FileInputStream in = new FileInputStream(file);){
                        byte[] buffer = new byte[1024]; // 读取文件的缓冲区
                        int length;
                        while ((length = in.read(buffer)) > 0) { // 读取文件内容并写入合并文件
                            out.write(buffer, 0, length);
                        }
                    }
                }
                System.out.println("文件合并完成");
                for (File f : files) {
                    f.delete();
                }
                System.out.println("分割文件删除完成");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

