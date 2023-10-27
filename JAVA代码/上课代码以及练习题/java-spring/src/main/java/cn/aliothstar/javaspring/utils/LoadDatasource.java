package cn.aliothstar.javaspring.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @作者：玉蘅
 * @项目名称：java-spring
 * @包名：cn.aliothstar.javaspring.utils
 * @文件名称：LoadDatasource
 * @代码功能：druid链接数据库
 * @时间：2023/10/27/11:43
 */

public class LoadDatasource {
    private static Properties properties;

    static {
        properties = new Properties();
        // getClassLoader 获取类加载器
        InputStream resource = LoadDatasource.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDatasource() throws Exception {
        return DruidDataSourceFactory.createDataSource(properties);
    }
}

