package JDBC.练习.one;

import JDBC.练习.one.MyDBUtils;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC.练习
 * @文件名称：MyDBUtilsTest
 * @代码功能：测试封装的工具类
 * @时间：2023/09/25/19:55
 */
public class MyDBUtilsTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        MyDBUtils myDBUtils = new MyDBUtils();// 只有一个连接对象
        ResultSet set = myDBUtils.executeQuery("select * from course");
        while (set.next()){
            int cid = set.getInt("course_id");
            String name = set.getString("course_name");
            int tid = set.getInt("teacher_id");
            System.out.printf("\033[36;1m课程ID：%d，课程名称：《%s》，教师ID：%d\n\033[0m",cid,name,tid);
        }
        int i = myDBUtils.executeUpdate("update course set course_name = ? where course_id = 4","计算机");
        System.out.println("影响行数：" + i);
        myDBUtils.close();
    }
}

