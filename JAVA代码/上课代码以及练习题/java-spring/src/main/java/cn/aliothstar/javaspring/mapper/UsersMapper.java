package cn.aliothstar.javaspring.mapper;

import cn.aliothstar.javaspring.model.Users;
import cn.aliothstar.javaspring.utils.DataSourceUtils;
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

    /**
     * 按照用户名和密码查询用户信息
     * @param username 输入的用户名
     * @param password 输入的密码
     * @return 查询到的用户信息
     */
    public Users selectByUsernameAndPassword(String username, String password) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from users where username = ? and password = ?";
        return queryRunner.query(DataSourceUtils.getConnection(), sql,  new BeanHandler<>(Users.class), username, password);
    }
}

