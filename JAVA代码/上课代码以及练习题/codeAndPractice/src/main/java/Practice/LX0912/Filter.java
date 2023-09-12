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
 * @文件名称：Filter
 * @代码功能：列出指定目录中的所有图片文件（例如，.jpg、.png、.gif）
 * @时间：2023/09/12/20:27
 */
public class Filter {
    public static void main(String[] args) {
        String pathname = "F:\\软件安装包";
        List<File> all = getAll(pathname);
        for (File file : all) {
            if (".zip".equals(file.getName().substring(file.getName().lastIndexOf('.')))){
                System.out.println(file);
            }
        }

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
            f.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    String name = f.getName();
                    return name.endsWith(".jpg") && file.isFile();
                }
            });
            fileList.addAll(getAll(f.getAbsolutePath()));
        }

        return fileList;
    }

}

