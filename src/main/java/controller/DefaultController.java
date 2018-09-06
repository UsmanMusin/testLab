package controller;


import model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import service.MyService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"user","role"})
public class DefaultController {

    @Autowired
    private MyService service;

    @RequestMapping("start.do")
    public ModelAndView start(HttpSession session) {
        if (session.getAttribute("user") == null) {
            ModelAndView mv = new ModelAndView("login");
            return mv;
        }
        else {
            if ((Integer)session.getAttribute("role") == 1) {
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
    public ModelAndView checkuser(@RequestParam String login, String password) {
        int resultCheck = service.checkUser(login, password);
        if(resultCheck==0){
            ModelAndView mv = new ModelAndView("login");
            mv.addObject("error","Неверный логин или пароль");
            return mv;
        }
        else {
            if(resultCheck==1){
                ModelAndView mv = new ModelAndView("admin");
                mv.addObject("user", login);
                mv.addObject("role",1);
                return mv;
            }
            else{
                ModelAndView mv = new ModelAndView("user");
                mv.addObject("user", login);
                mv.addObject("role",2);
                return mv;
            }
        }


    }

    @RequestMapping("exit.do")
    public ModelAndView exit(SessionStatus status) {
        status.setComplete();
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
