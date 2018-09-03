package controller;

import model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.MyService;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("rest")
public class REST_Controller {

    @Autowired
    private MyService service;


    @RequestMapping(value = "/allsongs.do", method = RequestMethod.GET, produces = "application/json")
    public List<Song> getAllSongs() {
        return service.getAllSongs();
    }


}
