package Code.JiHe;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：LinkedHashMapTest
 * @代码功能：
 * @时间：2023/09/11/14:18
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("1","a");
        hashMap.put("2","b");
        hashMap.put("3","c");
        Set<Map.Entry<String,String>> entries = hashMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // 如果 accessOrder 设置成 true 会按照访问顺序排序
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, false); // 16 0.75
        linkedHashMap.put(1, "wzry");
        linkedHashMap.put(3, "yys");
        linkedHashMap.put(2, "ys");
        linkedHashMap.put(4, "qqdzz");
        linkedHashMap.put(5, "hpjy");
        System.out.println(linkedHashMap.get(4));
        System.out.println(linkedHashMap.get(1));

        // 最后一个执行过访问的key会被放到LinkedHashMap的尾部
        System.out.println(linkedHashMap.get(2));

        System.out.println(linkedHashMap);

        Set<Map.Entry<Integer, String>> entries1= linkedHashMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries1) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }

    }
}

