package Practice.LX0911;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
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
        Map<String, LocalDate> map = new HashMap<>();
        map.put("岳山", LocalDate.of(2019, 8, 4));
        map.put("奥特曼", LocalDate.of(2038, 3, 5));
        map.put("天海", LocalDate.of(2020, 2, 18));
        map.put("无尘", LocalDate.of(2002, 5, 10));

        LocalDate today = LocalDate.now();

        Stream<Map.Entry<String, LocalDate>> entryStream = map.entrySet().stream().filter(new Predicate<Map.Entry<String, LocalDate>>() {
            @Override
            public boolean test(Map.Entry<String, LocalDate> stringLocalDateEntry) {
                return stringLocalDateEntry.getValue().getMonth()==LocalDate.now().getMonth()
                        && stringLocalDateEntry.getValue().getDayOfMonth()==LocalDate.now().getDayOfMonth();
            }
        });
        Stream<Map.Entry<String, LocalDate>> entryStream1 = map.entrySet().stream().filter(new Predicate<Map.Entry<String, LocalDate>>() {
            @Override
            public boolean test(Map.Entry<String, LocalDate> stringLocalDateEntry) {
                return stringLocalDateEntry.getValue().isBefore(LocalDate.now().minusDays(7))
                        || stringLocalDateEntry.getValue().isAfter(LocalDate.now().plusDays(7));
            }
        });
        entryStream.forEach(o -> System.out.println(o));
        entryStream1.forEach(o -> System.out.println(o));
    }

}

