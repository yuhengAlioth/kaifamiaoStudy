package Practice.LX0912;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0912
 * @文件名称：DeleteFile
 * @代码功能：删除指定目录中的所有文件和文件夹
 * @时间：2023/09/12/21:25
 */
public class DeleteFile {
    public static void main(String[] args) {
        String pathname = "F:\\软件安装包\\a";
        deleteAll(new File(pathname));

    }
    public static void deleteAll(File file){
        if (!file.exists()){
            System.out.println("没有这个文件夹、内容");
            return;
        }
        File[] files = file.listFiles();
        if (files != null){
            for (File file1 : files) {
                if (file1.isDirectory()){
                    deleteAll(file1);
                }else {
                    file1.delete();
                    System.out.println("删除完成");
                }
            }
        }
        file.delete();
    }

}

