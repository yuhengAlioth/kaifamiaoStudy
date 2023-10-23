package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：utils
 * @文件名称：TimeUtils
 * @代码功能：时间相关工具类
 * @时间：2023/10/21/18:03
 */

public class TimeUtils {


    /**
     * 将时间戳格式化成yyyy-MM-dd hh:mm:ss
     * @param time 传入时间戳
     * @return 返回24小时制的时间
     */
    public static String getTwentyfourHourSystemTime(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(time);
    }
}

