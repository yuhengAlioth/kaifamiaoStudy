package exercise.september.Sept8th;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;


public class Exec01 {
    public static void main(String[] args) {
        // 1.创建⼀个HashMap集合，使⽤三种遍历⽅式输出集合中的元素。
        HashMap<Integer, TVPlay> hashMap = new HashMap<>();
        hashMap.put(1, new TVPlay("甄嬛传", 74));
        hashMap.put(2, new TVPlay("长风渡", 40));
        hashMap.put(3, new TVPlay("莲花楼", 40));
        hashMap.put(4, new TVPlay("长相思", 40));
        hashMap.put(5, new TVPlay("qq", 40));

        // 通过键找值
        Set<Integer> integers = hashMap.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            TVPlay tvPlay = hashMap.get(next);
            System.out.println(next + "==" + tvPlay);
        }
        System.out.println("==============");
        Set<Map.Entry<Integer, TVPlay>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, TVPlay> en : entries){
            System.out.println(en);
        }
        System.out.println("==============");
        hashMap.forEach(new BiConsumer<Integer, TVPlay>() {
            @Override
            public void accept(Integer integer, TVPlay tvPlay) {
                System.out.println(integer+"=="+tvPlay);
            }
        });
    }
}
