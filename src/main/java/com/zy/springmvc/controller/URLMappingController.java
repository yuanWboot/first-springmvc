package com.zy.springmvc.controller;

import com.zy.springmvc.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/um")
public class URLMappingController {
    @GetMapping("/g")
    @ResponseBody
    public String getMapping(@RequestParam("manager_name") String managerName, Date createTime) {
        //http://localhost/um/g?manager_name=lili&createTime=1996-02-02
        //http://localhost/um/g?manager_name=张三&createTime=1996-02-02
        System.out.println("managerName:" + managerName);
        System.out.println("createTime:" + createTime);
        return "This is a get method";
    }

    @PostMapping("/p")
    @ResponseBody
    public String postMapping(String username, Long password) {
        System.out.println(username + ":" + password);
        return "This is a post method";
    }

    @PostMapping("/p1")
    @ResponseBody
    public String postMapping1(User user, @DateTimeFormat(pattern = "yyyy-MM-dd") Date createTime) {
        System.out.println(user.getUsername() + ":" + user.getPassword());
        System.out.println(createTime);
        return "这是post请求";
    }

    @GetMapping("/view")  //http://localhost/um/view?userId=1
    public ModelAndView shouView(Integer userId) {
        // ModelAndView nav = new ModelAndView("/view.jsp");
        //重定向
        // ModelAndView nav = new ModelAndView("redirect:/view.jsp");
        ModelAndView nav = new ModelAndView();
        nav.setViewName("/view.jsp");
        User user = new User();
        if (userId == 1) {
            user.setUsername("张三");
        } else if (userId == 2) {
            user.setUsername("李四");
        } else if (userId == 3) {
            user.setUsername("王五");
        }
        nav.addObject("u", user);
        return nav;
    }

    //String 与 ModelMap
    //Controller返回String的情况
    //1.方法被@Response注解描述:SpringMVC直接响应String字符串本身
    //2.方法不被@Response,则SpringMVC处理String指代的视图(页面)
    @GetMapping("/XXXXX")
    @ResponseBody
    public String shouView1(Integer userId, ModelMap modelMap) {
        //http://localhost/um/view?userId=1
        String view = "/um/view.jsp";
        User user = new User();
        if (userId == 1) {
            user.setUsername("张三");
        } else if (userId == 2) {
            user.setUsername("李四");
        } else if (userId == 3) {
            user.setUsername("王五");
        }
        modelMap.addAttribute("u",user);
        return view;

    }
}
