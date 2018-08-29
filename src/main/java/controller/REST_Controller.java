package controller;

import model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("rest")
public class REST_Controller {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/mybatiss")
    public ModelAndView indexView(@RequestParam String id, HttpServletResponse response){
        //response.setCharacterEncoding("utf-8");
        Song songs = userService.getUserUsingId(id);
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("song",songs);
        return modelAndView;
    }

    /*@RequestMapping(value = "/empset.do", method = RequestMethod.GET, produces = "application/json")
    public List<Employee> getEmpSet() {
        return dao.getAllEmployees();
    }

    @RequestMapping(value = "/delemp/{id}.do")
    public void delemp(@PathVariable long id){
        service.deleteEmp(id);
    }*/
}
