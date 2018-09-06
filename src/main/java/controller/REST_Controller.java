package controller;

import model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.MyService;

import javax.servlet.annotation.MultipartConfig;
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

    @RequestMapping(value = "/addsong.do", method = RequestMethod.POST, consumes = {"application/json"})
    public @ResponseBody String addSong(@RequestBody Song song){
        System.out.println("-------------------------------------------------------");
        System.out.println(song);
        System.out.println("-------------------------------------------------------");

        service.addSong(song.getName(), song.getArtist(),song.getAlbum(),song.getDate(),song.getDuration());
        return "OK";
    }

    @RequestMapping(value = "/editsong.do", method = RequestMethod.POST, consumes = {"application/json"})
    public @ResponseBody String editSong(@RequestBody Song song){
        System.out.println("-------------------------------------------------------");
        System.out.println(song);
        System.out.println("-------------------------------------------------------");

        service.editSong(song.getId(),song.getName(), song.getArtist(),song.getAlbum(),song.getDate(),song.getDuration());
        return "OK";
    }

    @RequestMapping(value = "/delsong/{id}.do", method = RequestMethod.GET)
    public @ResponseBody String editSong(@PathVariable int id){
        service.deleteSong(id);
        return "OK";
    }


}
