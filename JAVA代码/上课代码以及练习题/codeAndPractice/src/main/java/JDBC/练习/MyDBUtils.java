package JDBC.练习;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC.练习
 * @文件名称：DBUtils
 * @代码功能：封装对JDBC的操作
 * @时间：2023/09/25/16:38
 */
public class MyDBUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/kfm"; // 数据库地址
    private static final String USERNAME = "root"; // 数据库用户名
    private static final String PASSWORD = "root"; // 数据库密码
    private Connection connection = null; // 连接对象
    private PreparedStatement preparedStatement = null; // 执行对象
    private ResultSet resultSet = null; //

    /**
     * 获取连接对象信息
     * @return 连接MySQL数据库信息
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed()){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return connection;
        }
        return connection;
    }

    /**
     * 将 SQL 语句中的占位符替换成具体的值
     */
    private void setParameter(Object... values) throws SQLException {
        if (values != null && values.length >0){
            for (int i = 0; i < values.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }
        }
    }

    /**
     * 获取要执行的 SQL 对象
     * @param sql 预编译的SQL
     * @return 要执行的对象
     * @throws SQLException
     */
    private PreparedStatement preparedStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    /**
     * 传入查询的 SQL 语句进行执行
     * @param sql
     * @param values
     * @return 结果集
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ResultSet executeQuery(String sql,Object... values) throws SQLException, ClassNotFoundException {
        connection = getConnection(); // 获取连接对象
        preparedStatement = preparedStatement(sql); // 获取执行的 SQL 的对象
        setParameter(values); // 替换 SQL 中的占位符
        return preparedStatement.executeQuery(); // 执行
    }

    /**
     * 传入修改操作的 SQL 语句进行执行
     * @param sql
     * @param values
     * @return 影响行数
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int executeUpdate(String sql,Object... values) throws SQLException, ClassNotFoundException {
        connection = getConnection(); // 获取连接对象
        preparedStatement = preparedStatement(sql); // 获取执行的 SQL 的对象
        setParameter(values); // 替换 SQL 中的占位符
        return preparedStatement.executeUpdate(); // 执行
    }

    /**
     *关闭资源
     */
    public void close() throws SQLException {
        if (resultSet != null){
            resultSet.close();
            resultSet = null;
        }
        if (preparedStatement != null){
            preparedStatement.close();
            preparedStatement = null;
        }
        if (connection != null && !connection.isClosed()){
            connection.close();
            connection = null;
        }
    }

}

