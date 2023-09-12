package Practice.LX0911;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0911
 * @文件名称：Birthday
 * @代码功能：编写一个生日提醒程序，使用Map来存储人名和对应的生日日期
 * @时间：2023/09/11/21:33
 */
public class Birthday {
    // 够根据日期提醒用户哪些人今天过生日？如何筛选显示出最近七天过生日的用户
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("岳山", "2020-09-20");
        hashMap.put("奥特曼","2002-09-20");
        hashMap.put("天海", "2019-09-11");
        hashMap.put("无尘", "2021-09-12");


        // 跟据日期提醒用户哪些人今天过生日？
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
//        Set<Map.Entry<String, String>> set = entries.stream().filter(v -> {
//            // v key "人名" value "日期字符串"
//            return DateUtils.isBirthToday(v.getValue());
//        }).collect(Collectors.toSet());
//        System.out.println(set);
        entries.stream().filter(v->DateUtils.isBirthSevenDay(v.getValue())).forEach(e -> System.out.println(e));
    }

}

