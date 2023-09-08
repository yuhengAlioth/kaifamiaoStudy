package Code.JiHe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0908
 * @文件名称：HashMapDemo
 * @代码功能：
 * @时间：2023/09/08/19:15
 */
public class HashMapDemo {
    public static void main(String[] args) {

//        HashMap<String, String> hashMap = new HashMap<>(); // 容量是16，负载因子是0.75空集合对象
        new HashMap<>(20); // 容量是20，负载因子是0.75空集合对象
        new HashMap<>(20, 0.8f); // 容量是20， 负载因子是0.8空集合对象

        HashMap<String, String> hashMap = new HashMap<>(Map.of("1", "one", "2", "two")); // 传递一个map集合

        String three = hashMap.put("3", "three");// 如果key不存在映射，将key和value放进map中，并返回null

//        System.out.println(three);
        HashSet hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("1");
        String threeCopy = hashMap.put("3", "threeCopy"); // 如果key存在映射,用新的值覆盖掉旧的值，然后把旧的值返回回来
//        System.out.println(threeCopy);
//        Set<String> strings = hashMap.keySet();
//        for (String str : strings) {
//            System.out.println(str + "==" + hashMap.get(str));
//        }
        hashMap.clone();
        // 如果key存在映射，把key和apply方法返回的值进行映射  apply 方法返回的是null值 会删除掉这个存在的key
        // 如果key不存在映射，把key和apply方法返回的值进行映射 方法返回的是null值，不添加新的映射
        System.out.println("get4" + hashMap.get("4")); // null
        hashMap.put(null, null);
        hashMap.put(null, null); // 允许有null键但是只有一个
        System.out.println(hashMap);
        // abcdaaaabbbcccdd
        // "a" "b" "c" "d"
//        String str = "abcdaaaabbbcccdd";
//        HashMap<String, Integer> hashMap1 = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            hashMap1.compute(c + "", new BiFunction<String, Integer, Integer>() {
//                @Override
//                public Integer apply(String key, Integer value) {
//                    System.out.println(value);
//                    return value == null ? 1 : value + 1;
//                }
//            });
//        }
//        System.out.println(hashMap1);
        String v = hashMap.compute("3", new BiFunction<String, String, String>() {
            @Override
            public String apply(String key, String value) {
                System.out.println(key); // 前面输入的key的值
                System.out.println(value); // key对应的value的值
                return null;
            }
        });
        System.out.println(v); // four
        System.out.println("get4" + hashMap.get("3")); // 4 --> four
        System.out.println(hashMap);
    }
}

