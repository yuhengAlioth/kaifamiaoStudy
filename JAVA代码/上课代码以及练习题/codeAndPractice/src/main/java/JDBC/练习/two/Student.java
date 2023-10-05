package JDBC.练习.two;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC.练习.two
 * @文件名称：Student
 * @代码功能：数据库对应的学生类
 * @时间：2023/10/05/13:58
 */
@Data
public class Student {
    private Integer id;
    private String name;
    private Date birth;
    private String gender;

    public static class StudentHandler implements Handler<Student> {

        @Override
        public Student handle(ResultSet set) throws SQLException {
            Student student = new Student();
//            student.setId((int)params[0]);
//            student.setName((String) params[1]);
//            student.setBirth((Date) params[2]);
//            student.setGender((String) params[3]);
            student.setId(set.getInt("id"));
            student.setName(set.getString("name"));
            student.setBirth(set.getDate("birth"));
            student.setGender(set.getString("gender"));
            return student;
        }
    }
}

