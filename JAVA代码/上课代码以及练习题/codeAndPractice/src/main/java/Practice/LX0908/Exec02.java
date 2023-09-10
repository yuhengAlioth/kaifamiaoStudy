package exercise.september.Sept8th;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Exec02 {
    // 输⼊⼀个字符串，统计字符串中每个字符出现的次数.最后输出结果
    public static void main(String[] args) {
        String inputString = "HelloWorld!";
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("'" + entry.getKey() + "' 出现了 " + entry.getValue() + " 次");
        }
    }


//        map.forEach(new BiConsumer<Character, Integer>() {
//            @Override
//            public void accept(Character character, Integer integer) {
//                System.out.println(integer+"=="+character);
//            }
//        });
    }

