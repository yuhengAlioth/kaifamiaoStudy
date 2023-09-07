package Practice.LX0907;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;


/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0907
 * @文件名称：Demo
 * @代码功能：创建一个HashSet，包含一些日期对象 (java.util.Date)。编写代码，找到集合中的最早日期和最晚日期
 * @时间：2023/09/07/20:54
 */
public class Demo {
    public static void main(String[] args) {

        HashSet dateSet = new HashSet();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date(99,11 - 1,20);
        Date date2 = new Date(2014 - 1900,11 - 1,20);
        Date date3 = new Date(2023 - 1900,11 - 1,20);
        Date date4 = new Date(2019 - 1900,11 - 1,20);

        dateSet.add(date1);
        dateSet.add(date2);
        dateSet.add(date3);
        dateSet.add(date4);

        Date earliestDate = null; // 最早日期
        Date latestDate = null; // 最晚日期

        Iterator iterator = dateSet.iterator();
        if (iterator.hasNext()) {
            earliestDate = (Date) iterator.next();
            latestDate = earliestDate;
        }

        while (iterator.hasNext()) {
            Date currentDate = (Date) iterator.next();
            if (currentDate.before(earliestDate)) {
                earliestDate = currentDate;
            }
            if (currentDate.after(latestDate)) {
                latestDate = currentDate;
            }
        }

        String a1 = simpleDateFormat.format(earliestDate);
        String a2 = simpleDateFormat.format(latestDate);


        System.out.println("最早日期：" + a1);
        System.out.println("最晚日期：" + a2);
    }


}

