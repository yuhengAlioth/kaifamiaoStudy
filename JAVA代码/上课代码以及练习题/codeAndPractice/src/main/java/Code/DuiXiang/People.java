package Code.DuiXiang;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.DuiXiang
 * @文件名称：People
 * @时间：2023/08/15/14:50
 */
public class People {
    String name;
    int age;
    String sex;

    // 方法
    public void ZhaoDuiXiang() {
        System.out.println(name + age + sex + "找对象");
    }

    // 无参构造方法
    public People() {
        System.out.println("无参构造");
        // 构造方法和方法的区别
        // 修饰符 返回值类型 方法名（参数列表）{方法体}  调用 方法名(实参列表);
        // 修饰符 方法名(参数列表) {方法体}             调用  创建对象 使用 new 方法名(实参列表)
        // 1. 构造方法没有返回值类型，构造方法没有返回值 ，普通方法有返回值类型
        // 2. 方法名-->遵循标识符命名规范即可   构造方法名-->与类名一致
        // 3. 调用：方法名(实参列表);  构造的调用：创建对象 使用 new 方法名(实参列表)

        // 系统默认生成无参构造
        // 当类没有任何形式的构造方法的时候就会默认生成无参构造
    }

    // 有参构造方法
    public People(String name) {
        System.out.println(name);
        this.name = name;
    }

    public People(String name, int age,String sex) {
        // this(实参列表) --> 调用对应的重载的构造方法 并且必须写在构造方法的第一句
        this(name);
        System.out.println(age);
        this.age = age;
        this.sex = sex;
        this.ZhaoDuiXiang();
    }

    public static void main(String[] args) {
        People wt = new People();
        wt.name = "魏涛";
        wt.age = 22;
        wt.sex = "女";
        wt.ZhaoDuiXiang();
        People a = new People("时代风尚");
        People b = new People("斯达康",56,"男");
    }
}

