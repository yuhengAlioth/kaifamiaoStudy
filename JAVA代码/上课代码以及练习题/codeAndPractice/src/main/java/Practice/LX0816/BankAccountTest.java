package Practice.LX0816;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0816
 * @文件名称：BankAccountTest
 * @时间：2023/08/16/20:23
 */
public class BankAccountTest {
    static Scanner sc = new Scanner(System.in);
    static BankAccount bankAccount = new BankAccount();

    public static void main(String[] args) {
        while (true) {
            menu();
            System.out.println("请输入你要进行的操作，输入序号即可");
            int op = sc.nextInt();
            switch (op) {
                case 1 -> showInfo();
                case 2 -> saveMoney();
                case 3 -> drawMoney();
                case 4 -> {
                    System.out.println("退出成功！");
                    return;
                }
            }
        }
    }

    /**
     * 展示功能菜单
     */
    public static void menu() {
        System.out.println("******************");
        System.out.println("1. 查看账户信息");
        System.out.println("2. 存款");
        System.out.println("3. 取款");
        System.out.println("4. 退出");
        System.out.println("******************");
    }

    public static void showInfo() {
        bankAccount.setAccountNumber("00001");
        bankAccount.setAccountHolder("水神");
        System.out.println(bankAccount.info());
    }

    public static void saveMoney() {
        System.out.println("请输入存款金额");
        double money = sc.nextDouble();
        if (bankAccount.saveMoney(money)) {
            System.out.println("存款成功" + money + "， 当前余额" + bankAccount.getBalance());
        } else {
            System.out.println("存款失败" + money);
        }
    }

    public static void drawMoney() {
        System.out.println("请输入取款金额");
        double money = sc.nextDouble();
        if (bankAccount.drawMoney(money)) {
            System.out.println("取款成功" + money + "， 当前余额" + bankAccount.getBalance());
        } else {
            System.out.println("取款失败" + money);
        }
    }
}

