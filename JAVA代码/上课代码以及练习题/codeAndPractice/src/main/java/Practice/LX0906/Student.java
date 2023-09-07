package Practice.LX0906;

import java.util.LinkedList;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0906
 * @文件名称：Student
 * @代码功能：学生类
 * @时间：2023/09/06/19:02
 */


public class Student {
    private int id;
    private int score;

    public Student(int id, int score) {
        this.id = id;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID：" + id +
                ", 成绩：" + score +
                '}';
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        // 生成20个随机学生对象
        for (int i = 1; i <= 20; i++) {
            int id = i;
            int score = (int) (Math.random() * 41) + 60; // 随机生成60-100之间的分数
            linkedList.add(new Student(id, score));
        }

        // 找到分数最高和最低的学生
        int maxScore = Integer.MIN_VALUE;
        int minScore = Integer.MAX_VALUE;
        Student maxStudent = null;
        Student minStudent = null;

        for (Object st : linkedList) {
            Student student = (Student) st;
            if (student.getScore() > maxScore) {
                maxScore = student.getScore();
                maxStudent = student;
            }

            if (student.getScore() < minScore) {
                minScore = student.getScore();
                minStudent = student;
            }
        }

        System.out.println("分数最高的学生：");
        System.out.println("ID: " + maxStudent.getId());
        System.out.println("Score: " + maxStudent.getScore());

        System.out.println("分数最低的学生：");
        System.out.println("ID: " + minStudent.getId());
        System.out.println("Score: " + minStudent.getScore());

        System.out.println("===========================");

        for (Object st : linkedList) {
            System.out.println(st);
        }
    }
}


