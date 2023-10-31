package cn.aliothstar.javaspring.controller;

import cn.aliothstar.javaspring.model.Users;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @作者：玉蘅
 * @项目名称：java-spring
 * @包名：cn.aliothstar.javaspring.controller
 * @文件名称：Test2Controller
 * @代码功能：简化的控制器
 * @时间：2023/10/27/16:10
 */
@RestController
public class Test2Controller {
    @RequestMapping("/info1")
    @ResponseBody
    public String info() {
        return "我是info1，热部署了";
    }
    @RequestMapping("/info2")
    @ResponseBody
    public Users info2() {
        Users users = new Users();
        users.setId(1);
        users.setUsername("阿松大");
        users.setEmail("1534641@qq.com");
        return users;
    }
    @RequestMapping("/info3")
    @ResponseBody
    public Users[] info3() {
        Users users1 = new Users(2,"按时打","4511542","122@qq.vonm");
        Users users2 = new Users(3,"按asda时打","4511542","122@qq.vonm");
        Users[] users = {users1,users2};
        return users;
    }

    // ModelAndView 可以返回页面并携带数据
    // setViewName() 设置返回的页面
    // addObject(key, value) 设置携带的数据,可以设置多个  在视图层 ${key}
    // addAllObjects(map) 设置多个数据
    @RequestMapping("/mv")
    public ModelAndView mv() {
        // 可以返回页面并携带数据
        ModelAndView modelAndView = new ModelAndView();
        // 设置返回的页面
        modelAndView.setViewName("mv");
        Users users1 = new Users(2, "按时打", "4511542", "122@qq.vonm");
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "查询成功");
        map.put("stu", users1);
        // 设置多个数据
        modelAndView.addAllObjects(map);
        // 设置携带的数据,可以设置多个  在视图层 ${key}
//        modelAndView.addObject("msg", "hello modelAndView");
//        modelAndView.addObject("stu", s2);
        return modelAndView;
    }

}

