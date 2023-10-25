package cn.aliothstar.listener;

import cn.aliothstar.utils.Constant;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.listener
 * @文件名称：ServerListener
 * @代码功能：
 * @时间：2023/10/25/15:24
 */
// 监听web应用启动销毁
@WebListener
public class ServerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConcurrentHashMap<String, HttpSession> map = new ConcurrentHashMap<>();
        // 放到 application
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute(Constant.ONLINE_KEY, map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

