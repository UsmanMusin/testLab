package service;

import mapper.Mapper;
import model.Song;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyService {

    @Autowired
    private Mapper mapper;

    public Song getUserUsingId(String id) {
        System.out.println(mapper.getSongById(Integer.parseInt(id)).toString());
        return mapper.getSongById(Integer.parseInt(id));
    }

    public int checkUser(String login, String pass){
        User user = mapper.checkUser(login,pass);
        if(user == null){
            return 0;
        }
        else{
            if(user.isAdmin()){
                return 1;
            }
            else {
                return 2;
            }
        }
    }

    public List<Song> getAllSongs(){
        return mapper.getAllSongs();
    }

    public void addSong(String name, String artist, String album, int date, int duration){
        mapper.addSong(name, artist, album, date, duration);
    }

    public void editSong(int id , String name, String artist, String album, int date, int duration){
        mapper.editSong(id, name, artist, album, date, duration);
    }

    public void deleteSong(int id){
        mapper.deleteSong(id);
    }

    public List<Song> searchSongs(String name, String artist, String album, String date, String duration){
        List<Song> allsongs = mapper.getAllSongs();
        List<Song> filteredSongs = new ArrayList<Song>();
        for (Song s: allsongs) {
            if(((s.getName().equals(name))|(name.isEmpty()))&
            ((s.getArtist().equals(artist))|(artist.isEmpty()))&
                    ((s.getAlbum().equals(album))|(album.isEmpty()))&
                    ((Integer.toString(s.getDate()).equals(date))|(date.isEmpty()))&
                    ((Integer.toString(s.getDuration())).equals(duration)|(duration.isEmpty()))){
                filteredSongs.add(s);
            }
        }
        return filteredSongs;
    }


}