package controller;


import model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes({"user","role"})
public class DefaultController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/mybatis")
    public ModelAndView indexView(@RequestParam String id, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        Song song = userService.getUserUsingId(id);
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("song",song);
        return modelAndView;
    }

    @RequestMapping("start.do")
    public ModelAndView start(@SessionAttribute("user") String user,
                              @SessionAttribute("role") int role) {
        if (user == null) {
            ModelAndView mv = new ModelAndView("login");
            return mv;
        } else {
            if (role == 1) {
                ModelAndView mv = new ModelAndView("admin");
                return mv;
            }
            else {
                ModelAndView mv = new ModelAndView("user");
                return mv;
            }

        }
    }


    @RequestMapping(value = "check.do", method = RequestMethod.POST)
    public ModelAndView checkuser(@RequestParam String user, String pass) {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    /*@RequestMapping(value = "/user.do")
    public ModelAndView getUser(){
        User user = new User();
        user.setId("1");
        user.setCommand("frefge");
        user.setContent("ewgrg");
        user.setDescription("fefwe");
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("user", user);
        return modelAndView;
    }*/
}
