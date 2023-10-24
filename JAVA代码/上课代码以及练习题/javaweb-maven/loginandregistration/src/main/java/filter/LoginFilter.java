package filter;

import utils.Constant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：filter
 * @文件名称：LoginFilter
 * @代码功能：过滤器
 * @时间：2023/10/23/17:45
 */

// 1. 实现Filter
// 2. 重写方法 doFilter()
// 3. 注解配置 /* 所有请求都会通过这个过滤器
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("LoginFilter 执行");
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        String path = req.getContextPath();
        System.out.println("path=" + path); // 上下文路径 /kfm
        String uri = req.getRequestURI();
        System.out.println("uri=" + uri); // 本次请求的url /kfm/login
        uri = uri.substring(path.length()); // /login /css/login.css
        if ("/".equals(uri)) {
            // 放行 让浏览器访问本该访问的东西
            chain.doFilter(req, resp);
            return;
        }
        String[] urls = {"/login","/login.html", "/captcha", ".css", ".js", "/register", "/register.html","/online"};
        for (String url : urls) {
            if (uri.contains(url)) { // 说明访问的是登录/注册需要的资源，直接放行
                // 放行 让浏览器访问本该访问的东西
                System.out.println(uri + "放行");
                chain.doFilter(req, resp);
                return;
            }
        }
        // 判断是否已经登录 session  --> user 如果存在--> 放行 不存在-->跳转到登录页面
        HttpSession session = req.getSession();
        Object user = session.getAttribute(Constant.LOGIN_USER_KEY);
        System.out.println(user);
        if (user == null) { // 未登录，去登录页面
            System.out.println("未登录");
            resp.sendRedirect("/login");
            return;
        }
        // 放行 让浏览器访问本该访问的东西
        chain.doFilter(req, resp);
        System.out.println("LoginFilter 执行完毕");
    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter 销毁");
    }
}

