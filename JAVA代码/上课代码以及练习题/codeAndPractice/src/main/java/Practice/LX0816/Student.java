package Practice.LX0816;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0816
 * @文件名称：Student
 * @时间：2023/08/16/19:08
 */
public class Student {
    // 创建一个学生类 编写一个名为 Student 的类，
    //包含以下属性和方法：
    //属性：姓名（name）、年龄（age）、学号（studentId）、成绩（score）
    //方法：构造方法、获取姓名的方法、获取年龄的方法、获取学号的方法、获取成绩的方法、设置成绩的方法
    private String name;
    private int age;
    private int studentId;
    private double score;

    // 无参构造
    public Student() {

    }
    // 有参构造
    public Student(String name,int age,int studentId,double score){
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score > 0) {
            this.score = score;
        } else {
            System.out.println("输入成绩不合法");
        }
    }


}

