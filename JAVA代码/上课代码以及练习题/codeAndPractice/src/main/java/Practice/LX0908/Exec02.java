package Practice.LX0908;

import java.util.HashMap;
import java.util.function.BiFunction;

public class Exec02 {
    public static void main(String[] args) {
        // 输入一个字符串，统计字符串中每个字符出现的次数.最后输出结果
        String str = "abcdefghaaddcc";
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            hashMap.compute(c, new BiFunction<Character, Integer, Integer>() {
                @Override
                public Integer apply(Character character, Integer integer) {
                    System.out.println(character); // c
                    System.out.println(integer);  // c 映射的 value
                    return integer == null ? 1 : integer + 1;
                }
            });
            hashMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }
        System.out.println(hashMap);
    }
    }

