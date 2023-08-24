package Practice.LX0824.Marry;

import Practice.LX0824.Marry.Person;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0824
 * @文件名称：CAB
 * @时间：2023/08/24/19:18
 */
public class CAB {
    private static final Scanner input = new Scanner(System.in);
    private static final Person people = new Person();

    public static void main(String[] args) {
        // 有一个类 CAB ，有一个 canMarry 方法，接收两个 Person 对象，返回 boolean 值表示两个人能否结婚。
        //结婚的条件：男生22周岁，女生20周岁，必须是一男一女，并且两者都未婚。
        menu();
    }

    private static void menu() {
        System.out.println("===============================");
        System.out.println("*********结婚*********");
        System.out.println("1. 输入的一个人的信息");
        System.out.println("2. 输入第二个人的信息");
        System.out.println("3. 查看录入的两个人的信息");
        System.out.println("4. 两人是否可以结婚");
        System.out.println("0. 退出系统");
        System.out.println("===============================");
        System.out.println("请输入操作选项：");
        int type = input.nextInt();
        // 根据输入的数字进行对应的操作
        switch (type) {
            case 1 -> addPerson1();
            case 2 -> addPerson2();
            case 3 -> showAll();
            case 4 -> isMarry();
            case 0 -> {
                return;
            }
        }
    }

    /**
     * 添加第一个人的信息
     */
    public static void addPerson1() {
        System.out.print("请输入姓名：");
        String name = input.next();
        System.out.print("请输入性别：");
        String gender = input.next();
        System.out.print("请输入年龄：");
        String age = input.next();
        System.out.print("是否结婚(true 或 false)：");
        boolean isMarry = input.nextBoolean();
        char genders = gender.charAt(0); // 字符串转为字符
        Integer ages = new Integer(age); // String类型的数字转换为Integer包装类
        Person peo1 = new Person(name, genders, ages, isMarry);
        people.addPeople(peo1);
        System.out.println("添加成功！" + peo1);
        menu();
    }

    /**
     * 添加第二个人的信息
     */
    public static void addPerson2() {
        System.out.print("请输入姓名：");
        String name = input.next();
        System.out.print("请输入性别：");
        String gender = input.next();
        System.out.print("请输入年龄：");
        String age = input.next();
        System.out.print("是否结婚(true 或 false)：");
        boolean isMarry = input.nextBoolean();
        char genders = gender.charAt(0); // 字符串转为字符
        Integer ages = new Integer(age); // String类型的数字转换为Integer包装类
        Person peo2 = new Person(name, genders, ages, isMarry);
        people.addPeople(peo2);
        System.out.println("添加成功！" + peo2);
        menu();
    }

    /**
     * 查询输入的信息
     */
    public static void showAll() {
        people.showAll();
        menu();
    }

    /**
     * 判断两个人是否可以结婚
     */
    public static void isMarry() {
        boolean type = people.isMarry();
        String a = type ? "可以结婚" : "不能结婚";
        System.out.println(a);
        menu();
    }

}

