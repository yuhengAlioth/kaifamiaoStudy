package cn.aliothstar;

import java.io.IOException;
import java.nio.file.*;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar
 * @文件名称：CopyJavaFiles
 * @代码功能：复制指定格式的所有文件到另一个地方
 * @时间：2023/10/19/9:17
 */

public class CopyFiles {
    public static void main(String[] args) {
        // 源目录
        Path sourceDirectory = Paths.get("E:\\IDEA\\开发喵\\developing-meow-learning\\JAVA代码\\上课代码以及练习题\\javaweb\\src\\cn\\aliothstar\\servlet");
        // 目标目录
        Path targetDirectory = Paths.get("E:\\TestScratchFile");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDirectory, "*.java")) {
            for (Path path : directoryStream) {
                Path targetPath = targetDirectory.resolve(sourceDirectory.relativize(path));
                Files.copy(path, targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

