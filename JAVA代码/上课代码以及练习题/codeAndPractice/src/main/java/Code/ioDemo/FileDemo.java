package Code.ioDemo;

import java.io.File;
import java.util.Date;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：FileDemo
 * @代码功能：文件夹操作
 * @时间：2023/09/12/17:13
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("E:\\halo-aliothstar\\README.md");
        String parent = "E:\\docs";
        String child = "java";
        File parent1 = new File(parent);
        File file3 = new File(parent1, "java"); // 父目录的file对象 当前目录名
        new File("E:\\docs\\halo-aliothstar-docs"); // 完整的目录名
        File file1 = new File("E:\\docs\\halo-aliothstar-docs", "src"); // "E:\docs\halo-aliothstar-docs\src"  父目录的路径 当前目录名字
        System.out.println(file1);
        System.out.println(file.getName().substring(0, file.getName().lastIndexOf('.'))); // 文件名称
        System.out.println(file.getName().substring(file.getName().lastIndexOf('.'))); // 文件后缀名称
        System.out.println(file.getAbsolutePath()); // 返回绝对路径
        System.out.println(file.isDirectory()); // 判断是否是文件夹
        System.out.println(file.isFile()); // 判断是否是文件
        System.out.println(new Date(file.lastModified())); // 上次修改的时间 时间戳

        System.out.println("=====");
        System.out.printf("%.2fKB", file.length() / 1024.0); // 大小 单位是 B 1024 KB 1024 MB 1024 GB TB
        System.out.println();
        System.out.println("====");

        File file2 = new File("E:/");
        System.out.println("磁盘剩余空间：" + file2.getFreeSpace() / 1024.0 / 1024 / 1024 + "GB");
        System.out.println("磁盘总大小：" + file.getTotalSpace() / 1024.0 / 1024/ 1024 + "GB");
        System.out.println("磁盘可用空间：" + file.getUsableSpace() / 1024.0 / 1024/ 1024 + "GB");

    }
}

