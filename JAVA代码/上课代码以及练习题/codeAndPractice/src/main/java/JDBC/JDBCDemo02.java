package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC
 * @文件名称：JDBCDemo02
 * @代码功能：
 * @时间：2023/09/22/19:07
 */
public class JDBCDemo02 {
    public static void main(String[] args) {
        // 1. 注册驱动
        // DriverManager.registerDriver(new Driver());
        // 推荐  实现解耦   Driver 全限定类名
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (// 2. 获取连接
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kfm", "root", "root");
             // 4. 获取执行sql的对象
             Statement stat = conn.createStatement();) {
            // 3. 编写 sql
            String sql = "delete from course where course_id = 4";
            // 5. 执行sql  有返回值
            int i = stat.executeUpdate(sql); // 返回值是影响行数
            // 6. 解析返回值
            if (i > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

