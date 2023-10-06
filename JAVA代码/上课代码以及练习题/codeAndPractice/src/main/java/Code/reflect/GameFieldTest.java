package Code.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.reflect
 * @文件名称：GameFieldTest
 * @代码功能：使用反射访问类属性
 * @时间：2023/10/06/10:16
 */
public class GameFieldTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        class Example {
            String syntheticField;
        }
        Class<Game> cls = Game.class;
        // 获取所有 public 修饰的字段
        Field[] fields = cls.getFields();
        System.out.println(fields.length);
        // 获取所有访问修饰符修饰的字段
        Field[] declaredFields = cls.getDeclaredFields();
        System.out.println(declaredFields.length);
        // 获取一个指定的 public修饰的字段
        Field country = cls.getField("country");
        System.out.println(country);
        // 获取一个指定的任意修饰符修饰的字段
        Field name = cls.getDeclaredField("name");
        System.out.println(name);
        Game game = new Game();
        // 调用 setter 方法 设置值
        game.setCountry("中国");
        // Field 对象调用 set 方法设置  第一个参数 是要设置的对象 要设置的值
        country.set(game, "中国");
        System.out.println(game.getCountry());

        // name Field对象 访问修饰符是 private
        name.setAccessible(true);
        name.set(game, "原神");
        System.out.println(name.get(game));
        System.out.println(name);
        System.out.println(name.getDeclaringClass()); // 当前字段声明在哪个类
        System.out.println(name.getGenericType());    // 当前字段的数据类型 class java.lang.String
        System.out.println(name.getModifiers()); // private -- 2
        System.out.println(country.getModifiers()); // public -- 1
        Field code = cls.getDeclaredField("code");
        System.out.println(code.getModifiers()); // protected -- 4
        Field people = cls.getDeclaredField("people");
        System.out.println(people.getModifiers()); // 包访问修饰符 -- 0
        System.out.println(name.getName());
        System.out.println(name.getType()); // class java.lang.String
        System.out.println(name.isSynthetic());
        System.out.println(name.toGenericString());
        Field heroes = cls.getDeclaredField("heroes");
        // ParameterizedType 有泛型的类型  泛型接口 泛型类
//        ParameterizedType nameGenericType = (ParameterizedType) name.getGenericType(); // 错误 无法强转 因为name 字段数据类型是 String
//        System.out.println(nameGenericType);
        ParameterizedType genericType = (ParameterizedType) heroes.getGenericType();
        System.out.println(genericType.getActualTypeArguments()[0]);


        Field map = cls.getDeclaredField("map");
        ParameterizedType type = (ParameterizedType) map.getGenericType();
        System.out.println("key 的类型 ==>" + type.getActualTypeArguments()[0]);
        System.out.println("value 的类型 ==>" + type.getActualTypeArguments()[1]);

        Field genericClass = cls.getDeclaredField("genericClass");
        ParameterizedType type1 = (ParameterizedType)genericClass.getGenericType();
        // 获取泛型具体的类型
        Type[] arguments = type1.getActualTypeArguments();
        for (Type argument : arguments) {
            System.out.println(argument);
        }

    }
}

