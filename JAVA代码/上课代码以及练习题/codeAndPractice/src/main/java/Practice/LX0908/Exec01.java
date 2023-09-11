package Practice.LX0908;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;


public class Exec01 {
    public static void main(String[] args) {
        // 创建一个 HashMap 集合，使用三种遍历方式输出集合中的元素。
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1", 1);
        hashMap.put("2", 1);
        hashMap.put("3", 1);
        // forEach()
        hashMap.forEach(new BiConsumer<String, Integer>() {
            // s key  integer value
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s + "-->" + integer);
            }
        });
        hashMap.forEach((k, v) -> {
            System.out.println(k + "==>" + v);
        });
        // Set key 迭代器
        Set<String> set = hashMap.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer value = hashMap.get(key);
            System.out.println(key + "==>" + value);
        }
        // 获取所有键值对的Set集合
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        entrySet.forEach(entry -> { // entry 一个键值对组合
            System.out.println(entry.getKey() + "====" + entry.getValue());
        });
        System.out.println(hashMap);
    }
}
