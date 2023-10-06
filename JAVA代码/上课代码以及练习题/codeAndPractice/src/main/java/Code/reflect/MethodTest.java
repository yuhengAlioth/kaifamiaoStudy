package Code.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.reflect
 * @文件名称：MethodTest
 * @代码功能：
 * @时间：2023/10/06/15:38
 */
public class MethodTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Game> cls = Game.class;
        // 获取所有 public 修饰的方法
        Method[] methods = cls.getMethods();
        System.out.println(methods.length);
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
        // 获取所有方法 [重写的 或者自己扩展的方法 直接继承过来的没有]
        Method[] declaredMethods = cls.getDeclaredMethods();
        System.out.println(declaredMethods.length);
//        for (Method declaredMethod : declaredMethods) {
//            System.out.println(declaredMethod.getName());
//        }

        Method method = cls.getMethod("rank");
        System.out.println(method.getName());
        // public Game(String name)
        Constructor<Game> constructor = cls.getConstructor(String.class);
        Game game = constructor.newInstance("和平精英");
        System.out.println(game.getName());
        // 获取 一个指定名称 指定参数列表的 public 修饰的方法
        Method method1 = cls.getMethod("play", double.class); // play(double hours)
        System.out.println(method1.getName());
        // 获取 一个指定名称 指定参数列表的方法
        Method makeMoney = cls.getDeclaredMethod("makeMoney", double.class);
        System.out.println(makeMoney.getName());
        // 设置不检查访问权限
        makeMoney.setAccessible(true);
        // 执行方法  指定哪个对象去执行这个方法  实参参数列表  obj.makeMoney(12)
        makeMoney.invoke(new Game("王者"), 20.0);
        makeMoney.invoke(new Game("云深"), 20.0);

    }
}

