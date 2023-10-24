package listener;

import model.KfmUser;
import utils.Constant;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：listener
 * @文件名称：MyServletContextListener
 * @代码功能：监听ServletContext生命周期更改
 * @时间：2023/10/24/10:43
 */
// 1. 实现ServletContextListener接口
// 2. 重写方法
// 3. 注解部署
@WebListener
public class MyServletContextListener implements ServletContextListener {

    // 当web容器启动加载到当前web应用，触发该方法
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("web应用启动");
        ArrayList<KfmUser> objects = new ArrayList<>();
        // 存储登录的用户数量
        sce.getServletContext().setAttribute(Constant.ONLINE_KEY, objects);
    }

    // 当web容器关闭或者移除web应用，该方法执行
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("web应用销毁");
    }

    // 有一个存储数量的变量 --> 存储到 application（ServletContext）中 ，让web应用被加载的时候存储
    // 监听Session的变化 --> HttpSessionAttributeListener （监听Session属性的变化）
    // 新增session属性 --> 是否是新增登录用户属性 数量 + 1 --> added()
    // 删除session属性值 --> 数量 - 1 --> removed()
}

