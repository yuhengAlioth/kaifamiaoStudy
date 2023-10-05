package JDBC.练习.two;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC.练习.two
 * @文件名称：Test
 * @代码功能：测试类
 * @时间：2023/10/05/14:01
 */
public class Test {
    public static void main(String[] args) throws Exception {
        MyDBUtils2 dbUtils2 = new MyDBUtils2();
        String sql = "select * from student where id = ?";
//        List<Student> list = dbUtils.select("select * from student where id = ?", 1);
        Student student = dbUtils2.selectOne(sql, new Student.StudentHandler(), 1);
        List<Teacher> teachers = dbUtils2.select("select * from teacher", new Handler<Teacher>() {
            @Override
            public Teacher handle(ResultSet set) throws SQLException {
                Teacher teacher = new Teacher();
                teacher.setTeacherId(set.getInt("teacher_id"));
                teacher.setTeacherName(set.getString("teacher_name"));
                return teacher;
            }
        });
        System.out.println(student);
        dbUtils2.close();
    }
}

