package Code.ioDemo;

import java.io.*;
import java.nio.file.Files;
import java.util.Date;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ioDemo
 * @文件名称：CopyFile
 * @代码功能：复制文件的4种方法
 * @时间：2023/09/13/16:10
 */
public class CopyFile {
    public static void main(String[] args) {
        String target = "D:\\桌面\\winrar破解方法.md"; // 要复制的文件
        File targetFile = new File(target);
        String dest = "D:\\桌面\\copy"; // 要复制到的地方
        String name = targetFile.getName(); // 获取要复制文件的名称
        String destName = new Date().getTime() + name.substring(name.lastIndexOf('.')); // 复制后的名称
        File destFile = new File(dest + File.separator + destName); // 复制文件的完整路径
        read(targetFile,destFile);

    }
    private static void readAll(File target,File dest){
        if (!dest.getParentFile().exists()){ // 判断父级目录是否存在
            dest.getParentFile().mkdirs(); //不存在直接创建父级目录
        }
        try {
            FileInputStream in = new FileInputStream(target); // 输入流
            FileOutputStream out = new FileOutputStream(dest); // 输出流
            byte[] all = in.readAllBytes(); // 获取所有字节
            out.write(all); // 输出流写入内容
            out.flush(); // 清除输出流的缓存
            out.close(); // 关闭输出流
            in.close(); // 关闭输入流
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void copy(File target,File dest){
        try {
            Files.copy(target.toPath(),dest.toPath());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void transfer(File target,File dest){
        try {
            FileInputStream in = new FileInputStream(target);
            FileOutputStream out = new FileOutputStream(dest);
            in.transferTo(out);
            out.flush();
            out.close();
            in.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void read(File target,File dest){
        try {
            FileInputStream in = new FileInputStream(target);
            FileOutputStream out = new FileOutputStream(dest);
            byte[] bytes = new byte[100];
            int len = 0;
            while ((len = in.read(bytes)) != -1){
                out.write(bytes,0,len);
            }
            out.flush();
            out.close();
            in.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}

