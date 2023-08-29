package Practice.LX0829.Manage;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0829
 * @文件名称：Student
 * @代码功能：学生类
 * @时间：2023/08/29/16:42
 */
public class Student {
    private String name;
    private char gender;
    private double score;

    public Student() {
    }

    public Student(String name, char gender, double score) {
        this.name = name;
        this.gender = gender;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", score=" + score +
                '}';
    }
}

