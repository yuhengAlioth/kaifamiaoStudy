package Practice.LX0829.Manage;

public interface StudentManage2 {

    default void test() {
        test02();
    }

    static void test01() {
        System.out.println("test01");
        test02();
    }

    private static void test02() {

    }

    public abstract void printInfo2(Student[] students);

    void printAvgScore2(Student[] students);
}