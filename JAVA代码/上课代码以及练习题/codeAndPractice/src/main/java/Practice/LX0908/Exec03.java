package Practice.LX0908;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Exec03 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1, "安琪拉");
        map.put(2, "妲己");
        map.put(3, "貂蝉");
        map.put(4, "大乔");
        map.put(5, "小乔"); // 添加值
        map.remove(1); // 删除一个映射
//        map.replace(2, "孙策");
        map.put(2, "孙策");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
