package cn.aliothstar.dao;

import cn.aliothstar.entity.Infolist;
import cn.aliothstar.entity.Users;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.dao
 * @文件名称：InfolistDao
 * @代码功能：对infolist表操作
 * @时间：2023/10/17/18:55
 */

public class InfolistDao {
    private static final String URL = "jdbc:mysql://localhost:3306/kfm"; // 数据库地址
    private static final String USERNAME = "root"; // 数据库用户名
    private static final String PASSWORD = "root"; // 数据库密码
    private Connection connection = null; // 连接对象


    /**
     * 获取连接对象信息
     * @return 连接MySQL数据库
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
     * 查询所有信息
     * @return
     */
    public List<Infolist> selectAll() {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from infolist";
        List<Infolist> query = null;
        try {
            query = queryRunner.query(getConnection(), sql, new BeanListHandler<>(Infolist.class));
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        }
        return query;

    }


}

