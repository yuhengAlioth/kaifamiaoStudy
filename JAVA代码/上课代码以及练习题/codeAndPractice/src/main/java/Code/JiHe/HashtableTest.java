package Code.JiHe;

import java.util.Hashtable;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：HashtableTest
 * @代码功能：
 * @时间：2023/09/11/14:09
 */
public class HashtableTest {
    public static void main(String[] args) {
        Hashtable<Integer,String> hashtable = new Hashtable<>();
        hashtable.put(1,"岳山");
        hashtable.put(2,"天海");

        System.out.println(hashtable.get(2));

        System.out.println(hashtable.keySet()); // [2, 1]

        System.out.println(hashtable.values()); // [天海, 岳山]

        System.out.println(hashtable.containsKey(3)); // false

        System.out.println(hashtable.containsValue("胡桃")); // false

    }

}

