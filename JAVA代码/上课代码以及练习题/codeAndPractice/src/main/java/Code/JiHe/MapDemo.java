package Code.JiHe;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：MapDemo
 * @代码功能：
 * @时间：2023/09/08/19:19
 */
public class MapDemo {

    public static void main(String[] args) {
        // K, V String , Integer of 返回一个不可修改的map集合
        Map<String, Integer> map = Map.of("1", 1, "2", 2, "3", 3);
//        map.put("3", 3);
//        map.remove("2");
        // "1"(key) 1(value)  key value Entry<String, Integer> key(String) value(Integer)
        // "2"  2
        // "3" 3
        // 通过键找对应的值 keySet()  get(key) 通过key获取value
        Collection<Integer> values = map.values(); // 值的集合
        System.out.println(values);
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer value = map.get(key);
            System.out.println(key + "-->" + value);
        }
        // entrySet() 获取到 map 中所有的键值对
        // Set<Student>
        // Set 中存储的对象类型是 Map.Entry<String, Integer>
        Set<Map.Entry<String, Integer>> entrySet =  map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            // Map.Entry<String, Integer> 存储的是key和value
            System.out.println(entry.getKey() + "==" + entry.getValue());
        }
        System.out.println("--forEach---");
        // forEach()方法
        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String key, Integer value) {
                System.out.println(key);
                System.out.println(value);
                System.out.println(key + "==" + value);
            }
        });

//        map.forEach((key, value) -> System.out.println(key + "-->" + value));

//        List<String> strings = List.of("1", "2");
//        strings.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
        //
    }
}

