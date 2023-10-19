package cn.aliothstar.dao;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.dao
 * @文件名称：UploadLog
 * @代码功能：对upload_log表的相关操作
 * @时间：2023/10/18/19:16
 */

public class UploadLogDao {
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
     * 插入上传文件的日志信息
     * @param ip IP地址
     * @param port 端口号
     * @param file_name 文件名称
     * @param file_type 文件类型
     * @param file_size 文件大小
     * @param file_upload_time 上传时间
     * @param link 下载链接
     * @return true表示插入成功
     */
    public boolean insertInfo(String ip,int port, String name, String type,String size,String time,String link){
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into upload_log(ip,port,file_name,file_type,file_size,file_upload_time,link) values (?,?,?,?,?,?,?)";
        try {
            queryRunner.update(getConnection(), sql, ip,port,name,type,size,time,link);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

