package Practice.LX0912;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：GetAllFiles
 * @代码功能：列出指定目录及其子目录下所有文件
 * @时间：2023/09/12/17:32
 */
public class GetAllFiles {
    public static void main(String[] args) {
        String pathname = "F:\\软件安装包";
        System.out.println(getAll(pathname));

    }

    public static List<File> getAll(String pathname) {
        File file = new File(pathname);
        if (file.isFile()) {
            return List.of(file);
        }
        List<File> fileList = new ArrayList<>();
        // 拿所有的文件
        File[] files1 =  file.listFiles(f -> f.isFile());
        fileList.addAll(Arrays.asList(files1));
        // 拿所有文件夹
        File[] files = file.listFiles(f -> f.isDirectory() && !f.isHidden());
        // 遍历所有文件夹下面的文件
        for (File f : files) {
            fileList.addAll(getAll(f.getAbsolutePath()));
        }
        return fileList;
    }
}

