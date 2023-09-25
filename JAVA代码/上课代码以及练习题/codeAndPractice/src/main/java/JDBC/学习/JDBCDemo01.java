package JDBC.学习;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC
 * @文件名称：Test
 * @代码功能：
 * @时间：2023/09/22/15:05
 */
public class JDBCDemo01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            // 注册数据库驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/kfm";
            // 获取数据库连接对象
            conn = DriverManager.getConnection(url, "root", "root");
            // 编写 sql 语句
            String sql = "insert into course values(4, '销售', 8)";
//            String sql = "delete from course where course_id = 4";
//            String sql = "update course set course_name = '哈桑' where course_id = 4";
//            String sql = "select * from course";
            // 获取执行 sql 的对象
            statement = conn.createStatement();
            // 执行 sql insert / delete / update --> executeUpdate select -->executeQuery()
            int i = statement.executeUpdate(sql);
            // 判断执行结果
            if (i > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

