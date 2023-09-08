package Code.JiHe;

import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：HashMapDemo02
 * @代码功能：
 * @时间：2023/09/08/19:19
 */
public class HashMapDemo02 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1", 11);
        hashMap.put("2", 22);
        hashMap.put("3", 33);
        hashMap.put("4", 44);
        hashMap.put("5", 55);
        // 当key没有映射，或者映射到null值，会执行后面的apply()方法，如果该方法返回null，不做任何操作
        Integer i = hashMap.computeIfAbsent("5", new Function<String, Integer>() {
            @Override
            public Integer apply(String key) {
                System.out.println(key);
                return 55;
            }
        });
        System.out.println(i); // 55
        System.out.println(hashMap); //
        System.out.println("computeIfPresent");
        // 当key存在映射，且非空，执行apply方法 如果返回的是null值，删除了原来的映射
        Integer va = hashMap.computeIfPresent("5", new BiFunction<String, Integer, Integer>() {
            @Override
            public Integer apply(String key, Integer value) {
                System.out.println(key);
                System.out.println(value);
                return value + 1;
            }
        });
        System.out.println(va);
        System.out.println(hashMap);
    }
}

