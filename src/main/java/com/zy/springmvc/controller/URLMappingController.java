package com.zy.springmvc.controller;

import com.zy.springmvc.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/um")
public class URLMappingController {
    @GetMapping("/g")
    @ResponseBody
    public String getMapping(@RequestParam("manager_name") String managerName,Date createTime){
        //http://localhost/um/g?manager_name=lili&createTime=1996-02-02
        System.out.println("managerName:"+managerName);
        System.out.println("createTime:"+createTime);
        return "This is a get method";
    }
    @PostMapping("/p")
    @ResponseBody
    public String postMapping(String username , Long password){
        System.out.println(username+":" + password);
        return "This is a post method";
    }

    @PostMapping("/p1")
    @ResponseBody
    public String postMapping1(User user,@DateTimeFormat(pattern = "yyyy-MM-dd") Date createTime){
        System.out.println(user.getUsername()+":" + user.getPassword());
        System.out.println(createTime);
        return "This is a post method";
    }
}
