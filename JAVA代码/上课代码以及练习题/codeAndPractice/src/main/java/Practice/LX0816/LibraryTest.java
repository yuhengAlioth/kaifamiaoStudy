package Practice.LX0816;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0816
 * @文件名称：LibrayTest
 * @时间：2023/08/17/11:38
 */
public class LibraryTest {
    private static Library lib = new Library();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            menu();
            System.out.println("请输入你的操作类型：");
            int op = sc.nextInt();
            switch (op) {
                case 1 -> showAll();
                case 2 -> addBook();
                case 3 -> selectBook();
                case 4 -> {
                    System.out.println("退出成功");
                    return;
                }
            }
        }
    }

    public static void menu() {
        System.out.println("*******************");
        System.out.println("1. 查看所有图书");
        System.out.println("2. 添加图书");
        System.out.println("3. 查询图书");
        System.out.println("4. 退出");
        System.out.println("*******************");
    }

    public static void showAll() {
        lib.showAll();
    }

    public static void addBook() {
        System.out.println("请输入图书名称：");
        String title = sc.next();
        System.out.println("请输入图书作者：");
        String author = sc.next();
        System.out.println("请输入图书出版年份：");
        int year = sc.nextInt();
        System.out.println("请输入图书价格：");
        double price = sc.nextDouble();
        Book book = new Book(title, author, year, price);
        if (lib.addBook(book)) {
            System.out.println("添加成功！" + book.getTitle());
        } else {
            System.out.println("添加失败");
        }
    }

    public static void selectBook() {
        System.out.println("请输入要查询图书名称：");
        String title = sc.next();
        Book book = lib.selectBook(title);
        if (book == null) {
            System.out.println("查无此书");
        } else {
            System.out.println(book.info());;
        }
    }
}

