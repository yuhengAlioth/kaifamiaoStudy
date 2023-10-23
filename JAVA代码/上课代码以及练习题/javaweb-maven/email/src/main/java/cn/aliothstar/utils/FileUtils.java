package cn.aliothstar.utils;

import java.io.File;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.utils
 * @文件名称：FileUtils
 * @代码功能：
 * @时间：2023/10/20/22:33
 */

public class FileUtils {
    public static File[] getFiles() {
        File file = new File(Constant.UPLOAD_PATH);
        return file.listFiles(f -> f.isFile());
    }
}

