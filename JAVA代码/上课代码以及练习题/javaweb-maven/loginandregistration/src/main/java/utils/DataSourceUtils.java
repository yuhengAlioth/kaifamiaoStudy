package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：utils
 * @文件名称：DataSourceUtils
 * @代码功能：数据库链接
 * @时间：2023/10/21/9:34
 */

public class DataSourceUtils {
    private static Connection connection;

    static {
        // 获取配置文件datasource.properties 所在的流里面信息
        InputStream in = DataSourceUtils.class.getClassLoader().getResourceAsStream("datasource.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
            String className = properties.getProperty("driverClassName");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            Class.forName(className);
            connection = DriverManager.getConnection(url, username, password);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}

