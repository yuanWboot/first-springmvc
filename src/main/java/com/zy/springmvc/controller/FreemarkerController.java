package com.zy.springmvc.controller;

import com.zy.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fm")
public class FreemarkerController {
    public ModelAndView showTest() {
        ModelAndView mav = new ModelAndView();
        User user = new User();
        user.setUsername("andy");
        mav.addObject("u",user);
        return mav;
    }
}
