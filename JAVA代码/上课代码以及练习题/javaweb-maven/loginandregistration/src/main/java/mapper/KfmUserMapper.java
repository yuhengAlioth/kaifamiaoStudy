package mapper;

import model.KfmUser;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：mapper
 * @文件名称：KfmUserMapper
 * @代码功能：处理kfm_user表的增删改查操作
 * @时间：2023/10/21/9:31
 */

public class KfmUserMapper {

    /**
     * 按照用户名和密码查询用户信息
     * @param username 输入的用户名
     * @param password 输入的密码
     * @return 查询到的用户信息
     */
    public KfmUser selectByUsernameAndPassword(String username, String password) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from kfm_user where username = ? and password = ?";
        return queryRunner.query(DataSourceUtils.getConnection(), sql,  new BeanHandler<>(KfmUser.class), username, password);
    }

    /**
     * 用户登录后将登录时间插入数据库表中
     * @param time 登录时间
     * @return true表示插入成功
     */
    public boolean updateLoginTime(String loginTime,String username){
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update kfm_user set last_login = ? where username = ?";
        try {
            queryRunner.update(DataSourceUtils.getConnection(), sql, loginTime,username);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询用户名是否被注册
     * @param username 用户名
     * @return 查到的信息
     */
    public KfmUser selectByUsername(String username) {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from kfm_user where username = ?";
        try {
            return queryRunner.query(DataSourceUtils.getConnection(), sql, new BeanHandler<>(KfmUser.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 插入注册用户信息
     * @param username 用户名
     * @param name 姓名
     * @param password 密码
     * @param birth 出生日期
     * @param createTime 账户创建时间
     * @param phone 电话
     * @param email 邮箱
     * @return true表示插入成功
     */
    public boolean registerUserInfo(String username,String name, String password,String birth,String createTime,String phone, String email){
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into kfm_user(username, name, password, birth, create_time, phone, email) values (?,?,?,?,?,?,?)";
        try {
            queryRunner.update(DataSourceUtils.getConnection(), sql, username, name, password, birth, createTime, phone, email);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}

