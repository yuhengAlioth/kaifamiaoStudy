package cn.aliothstar.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.utils
 * @文件名称：DataSourceUtils
 * @代码功能：
 * @时间：2023/10/20/22:32
 */

public class DataSourceUtils {
    private static Connection connection;

    static {
        // 获取 datasource.properties 所在的流
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

