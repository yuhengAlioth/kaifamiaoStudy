package Practice.LX0906;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0906
 * @文件名称：RoleManageTest
 * @代码功能：测试ArryList集合类
 * @时间：2023/09/06/16:12
 */
public class RoleManageTest {
    static RoleManage roleManage = new RoleManage();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }

    private static void menu() {
        System.out.println("====================");
        System.out.println("1. 显示所有角色");
        System.out.println("2. 添加角色");
        System.out.println("3. 按照等级排序");
        System.out.println("4. 按照命座排序");
        System.out.println("5. 删除所有等级小于90级的角色");
        System.out.println("0. 退出");
        System.out.println("====================");
        int type = sc.nextInt();
        switch (type) {
            case 1 -> roleManage.showAll();
            case 2 -> add();
            case 3 -> {
                roleManage.gradeSort(); // 先排序
                roleManage.showAll(); // 再显示
            }
            case 4 -> {
                roleManage.lifeSort();
                roleManage.showAll();
            }
            case 5 -> {
                roleManage.removeGrade(90);
                roleManage.showAll();
            }
            case 0 -> {
                System.exit(1);
            }
        }
    }

    private static void add() {
        System.out.println("请输入角色名：");
        String name = sc.next();
        System.out.println("请输入角色属性：");
        String property = sc.next();
        System.out.println("请输入角色稀有度：");
        int rare = sc.nextInt();
        System.out.println("请输入角色命座：");
        int life = sc.nextInt();
        System.out.println("请输入角色等级：");
        int grade = sc.nextInt();
        Role role = new Role(name, property, rare, life, grade);
        roleManage.addRole(role);
    }
}

