package Practice.LX0904;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0904
 * @文件名称：Test
 * @代码功能：测试问候语枚举
 * @时间：2023/09/04/14:13
 */
public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        int hour = date.getHours();
        WenHou why = null;
        if (hour > 6 && hour <= 8){
            why = WenHou.ZS;
            System.out.println(why.getMessage());
        } else if (hour > 8 && hour <= 11) {
            why = WenHou.SW;
            System.out.println(why.getMessage());
        } else if (hour > 11 && hour <= 13) {
            why = WenHou.ZW;
            System.out.println(why.getMessage());
        }else if (hour > 13 && hour <= 18) {
            why = WenHou.XW;
            System.out.println(why.getMessage());
        }else if (hour > 18 && hour <= 22) {
            why = WenHou.WS;
            System.out.println(why.getMessage());
        }else {
            System.out.println("凌晨好");
        }


        System.out.println("=================================");


        Greetings greetings = Greetings.GREETINGS;
        System.out.println(greetings.getMessage());


        System.out.println("=================================");

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(localTime.truncatedTo(ChronoUnit.SECONDS));




    }

}

