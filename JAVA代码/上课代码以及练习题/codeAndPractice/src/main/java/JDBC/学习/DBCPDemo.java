package JDBC.学习;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC.学习
 * @文件名称：DBCPDemo
 * @代码功能：DBCP连接数据库
 * @时间：2023/09/28/15:21
 */
public class DBCPDemo {
    public static void main(String[] args) throws SQLException, IOException {
        // 创建对象 设置属性 获取连接
//        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        basicDataSource.setUrl("jdbc:mysql://localhost:3306/kfm");
//        basicDataSource.setUsername("root");
//        basicDataSource.setPassword("");
//        Connection connection = basicDataSource.getConnection();
//        System.out.println(connection);

        // 加载配置文件  加载 properties 加载成一个 Properties 对象 使用BasicDataSourceFactory 创建 DataSource对象
        Properties properties = new Properties();
        properties.load(new FileInputStream("resources/dbcp.properties"));
        BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}

