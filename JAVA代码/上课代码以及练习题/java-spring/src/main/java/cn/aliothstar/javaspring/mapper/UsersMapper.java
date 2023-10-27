package cn.aliothstar.javaspring.mapper;

import cn.aliothstar.javaspring.model.Users;
import cn.aliothstar.javaspring.utils.DataSourceUtils;
import cn.aliothstar.javaspring.utils.LoadDatasource;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @作者：玉蘅
 * @项目名称：java-spring
 * @包名：cn.aliothstar.javaspring.mapper
 * @文件名称：UsersMapper
 * @代码功能：对users表的CRUD操作
 * @时间：2023/10/26/17:27
 */

public class UsersMapper {
    QueryRunner queryRunner;
    BasicRowProcessor basicRowProcessor;

    public UsersMapper() {
        try {
            queryRunner = new QueryRunner(LoadDatasource.getDatasource());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 处理数据行并将其映射到 Java Bean 对象上。
        GenerousBeanProcessor generousBeanProcessor = new GenerousBeanProcessor();
        basicRowProcessor = new BasicRowProcessor(generousBeanProcessor);
    }


    /**
     * 按照用户名和密码查询用户信息
     * @param username 输入的用户名
     * @param password 输入的密码
     * @return 查询到的用户信息
     */
    public Users selectByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "select * from users where username = ? and password = ?";
//        return queryRunner.query(DataSourceUtils.getConnection(), sql,  new BeanHandler<>(Users.class), username, password);
        return queryRunner.query(sql,  new BeanHandler<>(Users.class), username, password);
    }

    /**
     * 根据输入的信息继续注册用户
     * @param username 用户名
     * @param password 密码
     * @param email 邮箱
     * @return 1-插入数据库成功
     * @throws SQLException
     */
    public int insertUsers(String username, String password, String email) throws SQLException {
        String sql = "insert into users(username, password, email) values (?, ?, ?)";
//        return queryRunner.update(DataSourceUtils.getConnection(),sql, username, password, email);
        return queryRunner.update(sql, username, password, email);
    }
}

