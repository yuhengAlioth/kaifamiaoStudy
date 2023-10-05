package Code.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.reflect
 * @文件名称：StudentTest
 * @代码功能：测试类
 * @时间：2023/10/05/17:07
 */
public class StudentTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        // 获取 Student 类的字节码对象  Class<Student> 三种获取方式
        Class<Student> studentClass = Student.class;
        System.out.println("类名称：" + studentClass.getSimpleName());
        System.out.println("包名称：" + studentClass.getPackageName());
        System.out.println("全限定名称：" + studentClass.getCanonicalName());

        // 获取所有的 public 修饰的构造器
        Constructor<?>[] constructors = studentClass.getConstructors();
        System.out.println("数组长度：" + constructors.length);
        for (Constructor<?> constructor : constructors) {
            System.out.print(constructor.getParameterCount()+"\t");
        }
        System.out.println();

        // 其中一个 public 修饰的构造器 返回 指定字节码对象的参数类型的构造器
//        Constructor<Student> constructor = studentClass.getConstructor(int.class,String.class, Date.class);
        // 获取构造器参数个数
//        System.out.println(constructor.getParameterCount());

        // 获取一个 任意修饰符修饰的构造器 获取 Student 类中 String,Date 参数列表的构造器
        Constructor<Student> declaredConstructor = studentClass.getDeclaredConstructor(String.class, Date.class);
        System.out.println("含有String,Date参数列表的构造器个数：" + declaredConstructor.getParameterCount());

        // 不再检查构造器的访问修饰符
        declaredConstructor.setAccessible(true);

        // newInstance() 创建对象  new Student()
        Student zs = declaredConstructor.newInstance("张三", new Date());
        System.out.println(zs);

        // public 修饰的无参构造
        Constructor<Student> constructor = studentClass.getConstructor();
        Student student = constructor.newInstance();
        System.out.println(student);

        // 获取所有的构造器
        Constructor<?>[] declaredConstructors = studentClass.getDeclaredConstructors();
        System.out.println("所有构造器个数：" + declaredConstructors.length);

        Class<? extends Student> aClass = new Student().getClass();
        Class<?> aClass1 = Class.forName("Code.reflect.Student");
        System.out.println(studentClass == aClass);
        System.out.println(studentClass == aClass1);


    }

}

