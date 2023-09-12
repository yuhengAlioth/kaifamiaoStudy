package Code.ioDemo;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：FileFilterDemo
 * @代码功能：
 * @时间：2023/09/12/17:30
 */
public class FileFilterDemo {
    public static void main(String[] args) {
        File ks = new File("E:/KFM/考试");
        System.out.println(ks.isHidden()); // 文件是否是隐藏文件
        File[] files = ks.listFiles(); // 拿到目录下所有的文件和目录
        File[] noHidden = ks.listFiles(new FileFilter() { // 过滤掉 不符合accept 条件的文件或目录
            @Override
            public boolean accept(File f) {
                // f 当前目录下的每一个文件或目录
                String name = f.getName();
                return f.isDirectory() && !f.isHidden();
            }
        });
//        File[] noHidden = ks.listFiles(f -> f.isDirectory() && !f.isHidden());
        File[] files1 = ks.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println("dir==>" + dir);
                System.out.println("name==>" + name);
                File file = new File(dir, name);
                // dir 是当前的目录
                // name 是 ks目录每个文件的文件名
                return name.endsWith(".class") && file.isFile(); // files1 就是符合 名字 以 '.class' 结尾的文件
            }
        });
//        ks.listFiles((dir, name) -> {
//            File file = new File(dir, name);
//            return name.endsWith(".class") && file.isFile();
//        });
//        for (File f : noHidden) {
//            System.out.println(f.getName());
//        }

        File[] files2 = File.listRoots(); // 所有的磁盘分区
        for (File f : files2) {
            System.out.println("当前磁盘：" + f);
            System.out.println("总大小：" + f.getTotalSpace() / 1024.0 / 1024 / 1024 + "GB");
            System.out.println("剩余大小：" + f.getFreeSpace() / 1024.0 / 1024 / 1024 + "GB");
        }

        File file = new File("E:/temp01/temp/temp.txt");
//        if (file.exists()) { // 判断文件是否存在
//            System.out.println(file.length());
//        } else {
//            if (file.mkdir()) { // 只能创建一级目录
//                System.out.println("创建成功！");
//            }
//        }
//        if (file.exists()) { // 判断文件是否存在
//            System.out.println(file.length());
//        } else {
//            if (file.mkdirs()) { // 创建多级目录
//                System.out.println("创建成功！");
//            }
//        }

        if (file.getParentFile().exists()) { // 获取父级目录所在的File对象
            System.out.println("父级文件夹已经存在");
        } else {
            if (file.getParentFile().mkdirs()) {
                System.out.println("父级目录创建成功");
            }
        }
    }
}

