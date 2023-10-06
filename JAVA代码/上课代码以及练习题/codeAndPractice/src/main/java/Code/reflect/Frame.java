package Code.reflect;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.reflect
 * @文件名称：Frame
 * @代码功能：
 * @时间：2023/10/06/15:37
 */
public class Frame {

    public static void saveObject(Object obj) throws IllegalAccessException {
        // 获取属性名 以及属性值
        // 反射 获取类的成分  属性
        // 获取字节码对象
        Class<?> cls = obj.getClass();
        // 获取所有属性 Field
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            // 设置不检查访问权限
            field.setAccessible(true);

            System.out.print("字段名：" + field.getName() + "\t");
            System.out.print("字段值：" + field.get(obj));
            System.out.println();
        }
    }

    public static void saveObject(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            //
            System.out.println(field.getName());
        }
    }
}

class FrameTest {
    public static void main(String[] args) throws IllegalAccessException {
        Student zs = new Student(1, "张三", new Date());
        Game game = new Game("王者");
        Frame.saveObject(zs);
        System.out.println("++++");
        Frame.saveObject(game);
    }
}

