package Practice.LX0815;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0815
 * @文件名称：Student
 * @时间：2023/08/15/19:02
 */
public class Student {
    String name;
    String gender;
    int age;
    int id;
    double score;
    public String say(String name,String gender,int age,int id,double score){
//        this.name = name;
//        this.gender = gender;
//        this.age = age;
//        this.id = id;
//        this.score = score;
        return ("姓名：" + name + "\t" + "性别：" + gender + "\t" + "年龄：" + age + "\t" + "id：" + id + "\t" + "分数：" + score);
    }
}


