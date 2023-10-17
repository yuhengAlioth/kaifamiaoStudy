package cn.aliothstar.dao;

import cn.aliothstar.entity.Users;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.dao
 * @文件名称：UsersDao
 * @代码功能：对users表的相关操作
 * @时间：2023/10/17/9:55
 */
public class UsersDao {
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
    public List<Users> selectAll() {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from users";
        List<Users> query = null;
        try {
            query = queryRunner.query(getConnection(), sql, new BeanListHandler<>(Users.class));
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        }
        return query;

    }

    /**
     * 登录查询用户名和密码
     * @param username
     * @param password
     * @return
     */
    public Users selectByUsernameAndPassword(String username, String password) {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from users where username = ? and password = ?";
        try {
            return queryRunner.query(getConnection(), sql, new BeanHandler<>(Users.class), username, password);
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 注册用户查询用户名是否存在
     * @param username
     * @return
     */
    public Users selectByUsername(String username) {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from users where username = ?";
        try {
            return queryRunner.query(getConnection(), sql, new BeanHandler<>(Users.class), username);
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 插入注册用户信息
     * @param username
     * @param password
     * @param email
     * @return true表示插入成功
     */
    public boolean registerUserInfo(String username, String password, String email){
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into users(username,password,email) values (?,?,?)";
        try {
            queryRunner.update(getConnection(), sql, username, password,email);
            return true;
        } catch (SQLException e) {
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }




}

