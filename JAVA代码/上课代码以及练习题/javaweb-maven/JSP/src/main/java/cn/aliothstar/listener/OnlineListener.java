package cn.aliothstar.listener;

import cn.aliothstar.utils.Constant;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.listener
 * @文件名称：OnlineListener
 * @代码功能：
 * @时间：2023/10/25/15:24
 */
@WebListener
public class OnlineListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // 新增
        String name = event.getName(); // 获取当前新增的是哪一个属性
        if (Constant.LOGIN_USER_KEY.equals(name)) { // 说明是登录成功新增session属性
            // 修改存储在线人数的集合
            HttpSession session = event.getSession();
            ServletContext servletContext = session.getServletContext();
            ConcurrentHashMap<String, HttpSession> map = (ConcurrentHashMap<String, HttpSession>)
                    servletContext.getAttribute(Constant.ONLINE_KEY);
            map.put(session.getId(), session);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        String name = event.getName();
        if (Constant.LOGIN_USER_KEY.equals(name)) {
            // 修改存储在线人数的集合
            HttpSession session = event.getSession();
            ServletContext servletContext = session.getServletContext();
            ConcurrentHashMap<String, HttpSession> map = (ConcurrentHashMap<String, HttpSession>) servletContext.getAttribute(Constant.ONLINE_KEY);
            map.remove(session.getId());
        }
    }
}

