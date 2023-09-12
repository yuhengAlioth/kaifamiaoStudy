package Practice.LX0912;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0912
 * @文件名称：SizeFile
 * @代码功能：计算指定目录及其子目录中所有文件的总大小
 * @时间：2023/09/12/19:10
 */
public class SizeFile {
    public static void main(String[] args) {
        String pathname = "F:\\软件安装包";
        double sizeAll = getSizeAll(pathname);
        System.out.printf("%.2f GB", sizeAll);

    }

    public static double getSizeAll(String pathname) {
        double sum = 0;
        List<File> fileList = getAll(pathname);
        for (File file : fileList) {
            sum += file.length();
        }

        return sum / 1024.0 / 1024 / 1024;
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

