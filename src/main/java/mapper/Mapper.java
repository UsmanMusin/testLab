package mapper;

import model.Song;
import model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Mapper {
    @Select("select * from APP.SONG where id = #{id}")
    public Song getSongById(@Param("id") int id);

    @Select("select * from message where command = #{command}")
    public Song getUserUsingCommand(@Param("command") String command);

    @Select("select * from APP.USERS where login = #{login} AND password = #{password}")
    public User checkUser(@Param("login") String login, @Param("password") String password);

    @Select("select * from APP.SONG")
    public List<Song> getAllSongs();

    @Insert("insert into APP.SONG(name,artist,album,date,duration) " +
            "VALUES(#{name}, #{artist}, #{album}, #{date}, #{duration})")
    public void addSong(@Param("name")String name, @Param("artist")String artist, @Param("album")String album,
                        @Param("date")int date, @Param("duration")int duration);
}