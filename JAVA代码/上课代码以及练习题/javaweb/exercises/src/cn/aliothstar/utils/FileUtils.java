package cn.aliothstar.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.utils
 * @文件名称：FileUtils
 * @代码功能：查看文件信息
 * @时间：2023/10/18/16:05
 */

public class FileUtils {
    /**
     * 将单位为B的字节数转为KB
     *
     * @param size 转换成KB单位的尺寸
     * @return
     */
    public static double getSize(long size) {
        // size -- B -- >KB
        return size * 1.0 / 1024;
    }

    /**
     * 将时间戳格式化成yyyy-MM-dd hh:mm:ss
     *
     * @param time yyyy-MM-dd HH:mm:ss 的时间表达式
     * @return
     */
    public static String getTime(long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}

