package Practice.LX0816;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0816
 * @文件名称：Library
 * @时间：2023/08/16/19:36
 */
public class Library {
    // int[] ints = {1, 2, 3, 4}
    // String[] strings = {"123", "345"}
    // Student[] students = {stu1, stu2, stu3};
    // Book[] books = {存储的是一个个的book对象}
    private Book[] books; // 定义 book类型 数组
    private int capacity; // 数组长度
    private static int count; // 记录存储图书的下标


    public Library() {
        this(2);
    }

    public Library(int capacity) {
        if (capacity < 2) {
            capacity = 2;
        }
        this.capacity = capacity;// 初始化数组长度
        books = new Book[capacity]; // 初始化数组
        books[0] = new Book("高等元素论", "mhy", 2019, 648);
        books[1] = new Book("小王子", "wy", 1980, 48);
        count = 2;
    }

    public Library(Book[] books) {
        this.books = books;
    }

    public boolean addBook(Book book) {
        grow();
        books[count] = book;
        count ++;
        return true;
    }
    public void grow() {
        if (count == books.length) { // 说明已经存储到极限了，此时要扩容
            Book[] books1 = new Book[books.length * 2];
            System.arraycopy(books, 0, books1, 0, books.length);
            books = books1;
        }
    }

    public void showAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(books[i].info());
        }
    }

    public Book selectBook(String title) {
        if (title == null) {
            return null;
        }
        for (int i = 0; i < count; i++) {
            if (title.equals(books[i].getTitle())) {
                return books[i];
            }
        }
        return null;
    }
}

