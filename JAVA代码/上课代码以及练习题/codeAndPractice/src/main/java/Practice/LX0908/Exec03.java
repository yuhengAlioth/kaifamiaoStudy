package exercise.september.Sept8th;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Exec03 {
    public static void main(String[] args) {
        // 遍历集合，并将序号与对应⼈名打印
        // 向该map集合中插⼊⼀个编码为5姓名为⼩乔的信息
        // 移除该map中的编号为1的信息
        // 将map集合中编号为2的姓名信息修改为
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "安琪拉");
        map.put(2, "妲己");
        map.put(3, "貂蝉");
        map.put(4, "大乔");
        map.put(5,"小乔");
        map.remove(1);
        map.replace(2,"孙策");
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println(integer + "==" + s);
            }
        });
        map.remove(1);
    }
}
