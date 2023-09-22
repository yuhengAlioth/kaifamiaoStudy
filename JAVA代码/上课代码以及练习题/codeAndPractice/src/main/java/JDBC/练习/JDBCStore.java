package JDBC.练习;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC.练习
 * @文件名称：JDBCStore
 * @代码功能：将数据库查询出的内容存储在集合中
 * @时间：2023/09/22/21:00
 */
public class JDBCStore {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        // 1.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // 2. 获取连接
        String url = "jdbc:mysql://localhost:3306/kfm?user=root&password=root";
        try (Connection conn = DriverManager.getConnection(url);
             // 3. 获取执行sql的对象
             Statement stat = conn.createStatement();) {
            // 4. 编写sql
            String sql = "select course_id as id,course_name from course";
            // 5. 执行sql
            ResultSet set = stat.executeQuery(sql);
            // 获取列数
            ResultSetMetaData metaData = set.getMetaData();
            int columnCount = metaData.getColumnCount(); // 获取数据库查询的条数

            // 6. 解析结果
            while (set.next()) {
                String string = "";
                for (int i = 1; i <= columnCount; i++) {
                    Object value = set.getObject(i);
                    string += value + " ";
                }
                stringList.add(string);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        stringList.forEach(o -> {
            System.out.println(o);
        });
    }
}

