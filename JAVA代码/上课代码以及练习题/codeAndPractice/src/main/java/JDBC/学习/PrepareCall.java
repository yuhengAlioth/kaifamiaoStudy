package JDBC.学习;

import java.sql.*;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC.学习
 * @文件名称：PrepareCall
 * @代码功能：
 * @时间：2023/09/26/20:13
 */
public class PrepareCall {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kfm", "root", "root");
        // JDBC中调用存储过程  CallableStatement
        CallableStatement callableStatement = conn.prepareCall("{call cal_score(?)}");
        callableStatement.setInt(1, 1);
        ResultSet resultSet = callableStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println(resultSet.getObject(1));
        }
//        CallableStatement callableStatement = conn.prepareCall("{call `sum`(?, ?, ?)}");
//        callableStatement.setInt(1, 2);
//        callableStatement.setInt(2, 4);
//        // 注入 OUT类型的参数 registerOutParameter(, 类型)
//        callableStatement.registerOutParameter(3, Types.INTEGER);
//        callableStatement.execute();
//        // getXXX(3)
//        int sum = callableStatement.getInt(3);
//        System.out.println(sum);
    }
}

