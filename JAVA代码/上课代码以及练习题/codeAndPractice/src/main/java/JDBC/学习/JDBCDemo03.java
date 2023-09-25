package JDBC.学习;

import java.sql.*;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC
 * @文件名称：JDBCDemo03
 * @代码功能：查询操作
 * @时间：2023/09/22/19:08
 */
public class JDBCDemo03 {
    public static void main(String[] args) {
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
             Statement stat = conn.createStatement();){
            // 4. 编写sql
            String sql = "select course_id as id,course_name from course";
            // 5. 执行sql
            ResultSet set = stat.executeQuery(sql);
            // 获取列数
            ResultSetMetaData metaData = set.getMetaData();
            int columnCount = metaData.getColumnCount(); // 获取数据库查询的条数
            System.out.println("列数：" + columnCount);

            String columnClassName = metaData.getColumnClassName(1); // 获取数据库第一列所对应的java类型
            System.out.println("数据库第一列所对应的java类型:" + columnClassName);

            String catalogName = metaData.getCatalogName(1); // 数据库名称
            System.out.println("数据库名称：" + catalogName);

            int columnDisplaySize = metaData.getColumnDisplaySize(1); // 返回指定列最大宽度
            System.out.println("列最大宽度：" + columnDisplaySize);

            String columnLabel = metaData.getColumnLabel(1);
            System.out.println("起别名了显示别名：" + columnLabel); // 如果起别名了 就是别名

            String columnName = metaData.getColumnName(1);
            System.out.println("数据库中字段原始名称：" + columnName); // 数据库中的原始字段名

            int columnType = metaData.getColumnType(2); // 获取对应列的数据库数据类型 数字格式
            System.out.println("对应列的数据库数据类型 数字格式：" + columnType);

            String columnTypeName = metaData.getColumnTypeName(1); // 获取对应列的数据库数据类型
            System.out.println("应列的数据库数据类型：" + columnTypeName);

            String schemaName = metaData.getSchemaName(1);
            System.out.println(schemaName);

            String tableName = metaData.getTableName(1); // 获取表名称
            System.out.println("表名称：" + tableName);

            boolean autoIncrement = metaData.isAutoIncrement(1); // 列是否自增
            System.out.println("列是否自增：" + autoIncrement);

            boolean caseSensitive = metaData.isCaseSensitive(1); // 列的大小写是否重要
            System.out.println("列的大小写是否重要：" + caseSensitive);
            // 6. 解析结果
            while (set.next()) { // 类比 hesNext() next() 整合到一起了
//                Object object = set.getObject("no");
//                Object object1 = set.getObject("name");
//                Object object2 = set.getObject("loc");
//                System.out.println(object + " " + object1 + " " + object2);
                for (int i = 1; i <= columnCount; i++) {
                    Object value = set.getObject(i);
//                    System.out.print(value == null ? " " : value.getClass() + " ");
                    System.out.print(value + " ");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

