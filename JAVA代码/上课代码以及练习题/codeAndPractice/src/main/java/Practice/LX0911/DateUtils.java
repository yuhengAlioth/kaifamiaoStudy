package Practice.LX0911;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0911
 * @文件名称：DateUtils
 * @代码功能：日期工具类
 * @时间：2023/09/12/11:28
 */
public class DateUtils {
    /**
     * 将字符串转换成日期
     *
     * @param birth 获取的日期字符串
     * @return 转换成Date对象
     */
    public static Date converseDate(String birth) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(birth);
        } catch (ParseException e) {
            throw new RuntimeException("你的生日格式不对，应该是yyyy-MM-dd的格式");
        }
    }


    /**
     * 是否是今天的生日
     *
     * @param birth 要判断的生日
     * @return 是否今天过生日
     */
    public static boolean isBirthToday(String birth) {
        Date date = converseDate(birth);
        // 月和日相等
        Date d = new Date();
        return date.getMonth() == d.getMonth() && date.getDate() == d.getDate();
    }

    /**
     * 最近七天过生日
     *
     * @param birth 要判断的生日
     * @return 是否最近七天内过生日
     */
    public static boolean isBirthSevenDay(String birth) {
        Date date = converseDate(birth);
        // Date 转换成LocalDate
        LocalDate localDate = dateToLocalDate(date);
//        localDate.getMonth();
        localDate.getDayOfYear();
        Date d = new Date();
        LocalDate localDate1 = dateToLocalDate(d);
        LocalDate localDate2 = localDate1.plusDays(7);
        localDate2.getDayOfYear();
        // 生日 晚于今天 早于7天后 不能判断年  判断月份 和日期
        return localDate.getDayOfYear() - localDate1.getDayOfYear() <= 7
                && localDate.getDayOfYear() - localDate1.getDayOfYear() >= 0;
    }


    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }
}

