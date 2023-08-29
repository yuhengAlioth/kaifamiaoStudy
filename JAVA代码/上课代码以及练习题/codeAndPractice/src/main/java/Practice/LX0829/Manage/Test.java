package Practice.LX0829.Manage;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0829.Manage
 * @文件名称：Test
 * @代码功能：测试
 * @时间：2023/08/29/19:30
 */
public class Test {

    public static void main(String[] args) {
        Student stu1 = new Student("张三", '男', 90);
        Student stu2 = new Student("李四", '男', 81);
        Student stu3 = new Student("王五", '女', 72);
        Student stu4 = new Student("赵六", '女', 61);
        Student[] students = {stu1, stu2, stu3, stu4};

        StudentManagement stuM = new StudentManagement();
        StudentManage studentManage = stuM;
        studentManage.printInfo(students);
        studentManage.printAvgScore(students);

        StudentManage2 studentManage2 = stuM;
        studentManage2.printAvgScore2(students);
        studentManage2.printInfo2(students);

        StudentManage2.test01();
    }
}

