package Code.reflect;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.reflect
 * @文件名称：MethodTest02
 * @代码功能：
 * @时间：2023/10/06/15:39
 */
public class MethodTest02 {
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Game.class.getDeclaredMethod("play", double.class, int.class);
        System.out.println(Arrays.toString(method.getExceptionTypes())); // 抛出的异常类型 返回是一个数组
        System.out.println(Arrays.toString(method.getParameterTypes())); // 参数列表的类型 Class[]
        System.out.println(method.getReturnType()); // 获取返回值类型
        System.out.println(method.getModifiers()); // 返回修饰符 16 + 1 public 1 final  16
        System.out.println(method.getParameterCount()); // 参数列表的数量
        System.out.println(Arrays.toString(method.getGenericParameterTypes())); // Type[]
        System.out.println(method.isVarArgs()); // 参数列表是否是可变长度参数
        Method test = Game.class.getDeclaredMethod("test", Object[].class);
        System.out.println(test.isVarArgs()); // true
        System.out.println(test.isDefault()); // false

        Method test1 = MyInterface.class.getDeclaredMethod("test");
        System.out.println(test1.isDefault()); // true 是否是 default关键字修饰的方法
        System.out.println(test.isBridge());

        Method[] methods = Game.class.getDeclaredMethods();
        // clone 继承自Object 子类中做了一些扩展 此时子类中 字节码 会有两个clone方法 一个是返回 Game类型 还有一个返回Object类型
        for (Method method1 : methods) {
            System.out.println(method1 + "-==>" + method1.isBridge());
        }

    }
}

