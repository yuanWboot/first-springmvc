package com.zy.springmvc.controller;

import com.zy.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/um")
public class URLMappingController {
    @GetMapping("/g")
    @ResponseBody
    public String getMapping(@RequestParam("manager_name") String managerName){
        //http://localhost/um/g?manager_name=lili
        System.out.println("managerName"+managerName);
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
    public String postMapping1(User user){
        System.out.println(user.getUsername()+":" + user.getPassword());
        return "This is a post method";
    }
}
