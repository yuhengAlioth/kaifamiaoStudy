package Code.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.reflect
 * @文件名称：GameTest
 * @代码功能：
 * @时间：2023/10/06/10:17
 */
public class GameTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1. 获取字节码对象
        // 1. 类名.class
        // 2. 对象名.getClass
        // 3. Class.forName("全限定名")
        Class<?> aClass = Class.forName("Code.reflect.Game");
        // 只能调用无参构造
        Game instance1 = (Game) aClass.newInstance();
        System.out.println(instance1);
        // 2. 获取类的成分 （构造器、成员、方法）
        // 获取构造器
        // 获取一个 public 修饰的指定构造器 通过参数列表指定 含有一个 String 类型参数的构造器
        Constructor<?> constructor = aClass.getConstructor(String.class);
//        Constructor<?> constructor1 = aClass.getConstructor(String.class, int.class, double.class); 无法获取到private修饰的
//        System.out.println(constructor1);
        // 通过构造器创建对象 设置不考虑访问修饰符
        constructor.setAccessible(true);  // [暴力反射]
        Game instance = (Game) constructor.newInstance("王者荣耀");// 获取对象 == 调用构造方法 new Game("")
        System.out.println(instance.getName());
        // 获取多个 public 修饰的构造器
        Constructor<?>[] constructors = aClass.getConstructors();
        System.out.println(constructors.length);
        // 获取任意修饰符修饰的指定构造器
        Constructor<?> allArguments = aClass.getDeclaredConstructor(String.class, int.class, double.class);
        allArguments.setAccessible(true);
        Game qq = (Game) allArguments.newInstance("球球大作战", 4, 648);
        System.out.println(qq);
        // 获取任意修饰符修饰的所有构造器
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        System.out.println(declaredConstructors.length);

    }
}

