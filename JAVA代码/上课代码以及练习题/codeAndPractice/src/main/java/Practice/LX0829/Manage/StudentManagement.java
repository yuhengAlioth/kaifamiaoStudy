package Practice.LX0829.Manage;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0829.Manage
 * @文件名称：StudentManagement
 * @代码功能：实现接口
 * @时间：2023/08/29/19:29
 */
public class StudentManagement implements StudentManage, StudentManage2 {


    @Override
    public void test() {

    }

    static void test01() {}

    @Override
    public void printInfo(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void printAvgScore(Student[] students) {
        double sum = 0;
        for (Student student : students) {
            sum += student.getScore();
        }
        System.out.println(sum / students.length);
    }

    @Override
    public void printInfo2(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
        int maleCount = 0;
        int femaleCount = 0;
        for (Student student : students) {
            if (student.getGender() == '男') {
                maleCount ++;
            } else if (student.getGender() == '女') {
                femaleCount ++;
            }
        }
        System.out.printf("男生人数：%d, 女生人数%d", maleCount, femaleCount);
        System.out.println();
    }

    @Override
    public void printAvgScore2(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].getScore() > students[j + 1].getScore()) {
                    Student stu = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = stu;
                }
            }
        }
        double sum = 0;
        for (int i = 1; i < students.length - 1; i++) {
            sum += students[i].getScore();
        }
        System.out.println(sum / (students.length - 2));
    }
}




