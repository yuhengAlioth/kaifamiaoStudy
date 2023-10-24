package listener;

import model.KfmUser;
import utils.Constant;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：listener
 * @文件名称：MyHttpSessionAttributeListener
 * @代码功能：监听session属性的变化
 * @时间：2023/10/24/10:31
 */
@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    // 属性新增触发
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("session新增了" + event.getName() + "属性-->" + event.getValue());
        // 当新增的是登录用户信息的时候，才应该 + 1
        if (Constant.LOGIN_USER_KEY.equals(event.getName())) { // 新增的是登录信息属性
            ServletContext servletContext = event.getSession().getServletContext();
            List<KfmUser> attribute = (List<KfmUser>) servletContext.getAttribute(Constant.ONLINE_KEY);
            attribute.add((KfmUser)event.getValue());

        }
    }

    // 属性删除触发
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session删除了" + event.getName() + "属性");
        if (Constant.LOGIN_USER_KEY.equals(event.getName())) {
            ServletContext servletContext = event.getSession().getServletContext();
            List<KfmUser> attribute = (List<KfmUser>) servletContext.getAttribute(Constant.ONLINE_KEY);
            attribute.remove((KfmUser)event.getValue());

        }
    }

    // 属性修改触发
    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("session修改了" + event.getName() + "属性-->" + event.getValue());
    }

}

