package JDBC.学习;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC.学习
 * @文件名称：Transfer
 * @代码功能：
 * @时间：2023/09/26/15:07
 */
public class Transfer {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/kfm?user=root&password=root";
        try {
            conn = DriverManager.getConnection(url);
            // 开启事务
            conn.setAutoCommit(false);
            String sql = "update score set score = score - ? where student_id = ? and course_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, -5);
            pstmt.setInt(2, 1);
            pstmt.setInt(3, 1);
            // 执行事务
            pstmt.executeUpdate();
            System.out.println("成绩加5分");

            if (true) throw new RuntimeException("修改异常");

            sql = "update score set score = score - ? where student_id = ? and course_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 5);
            pstmt.setInt(2, 1);
            pstmt.setInt(3, 1);
            // 执行事务
            pstmt.executeUpdate();
            System.out.println("成绩减5分");

            // 提交事务
            conn.commit();


        } catch (Exception e) {
            e.printStackTrace();
            // 事务回滚
            try {
                conn.rollback();
                System.out.println("事务回滚成功");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

