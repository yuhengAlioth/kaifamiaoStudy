package Code.JiHe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：Cart
 * @代码功能：ArryList集合
 * @时间：2023/09/06/14:54
 */
public class Cart {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        // 太 小 兔 皮 拖鞋 库 T i = 0
        // 小 兔 皮 拖鞋 库 T    i = 1
        // 小 皮 拖鞋 库 T       i = 2
        // 小 皮 拖鞋 T          i = 3
        arrayList.add("太阳花抱枕");
        arrayList.add("小怪兽抱枕");
        arrayList.add("小兔子抱枕");
        arrayList.add("皮卡丘抱枕");
        arrayList.add("拖鞋");
        arrayList.add("库洛米抱枕");
        arrayList.add("T恤");

        // 删除所有包含某个内容的元素 ,forEach里面不能进行添加和删除的操作

//        arrayList.forEach(obj -> {
//            String str = (String) obj;
//            if (str.contains("抱枕")) {
//                // 下面两个操作会导致 modCount ++
////                arrayList.add("皮卡丘抱枕"); 错误
////                arrayList.remove(obj);     错误
//            }
//        });


        // 删除集合的元素 在迭代器使用迭代器的remove

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String str = (String) iterator.next();
            System.out.println(str);
            if (str.contains("抱枕")) {
//                 arrayList.remove(str); 错误
                iterator.remove();
//                arrayList.add(""); 错误
//                iterator.add(); 不存在该方法
            }
        }


        // 增强for循环中也不能删除集合元素

//        for (Object o : arrayList) {
//            String str = (String) o;
//            if (str.contains("抱枕")) {
//                arrayList.remove(str);
//            }
//        }


        // 普通for循环中删除 注意循环变量

        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            if (str.contains("抱枕")) {
                arrayList.remove(str);
                i--;
            }
        }
        arrayList.forEach(obj -> System.out.println(obj));
    }
}