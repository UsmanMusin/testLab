package controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class DefaultController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/mybatis")
    public ModelAndView indexView(@RequestParam String id, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        User user = userService.getUserUsingId(id);
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/user.do")
    public ModelAndView getUser(){
        User user = new User();
        user.setId("1");
        user.setCommand("frefge");
        user.setContent("ewgrg");
        user.setDescription("fefwe");
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
