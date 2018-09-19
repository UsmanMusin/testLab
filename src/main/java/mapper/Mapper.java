package mapper;

import model.Song;
import model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Mapper {
    @Select("select * from APP.SONG where id = #{id}")
    public Song getSongById(@Param("id") int id);

    @Select("select * from APP.USERS where login = #{login} AND password = #{password}")
    public User checkUser(@Param("login") String login, @Param("password") String password);

    @Select("select * from APP.SONG")
    public List<Song> getAllSongs();

    @Insert("insert into APP.SONG(name,artist,album,date,duration) " +
            "VALUES(#{name}, #{artist}, #{album}, #{date}, #{duration})")
    public void addSong(@Param("name")String name, @Param("artist")String artist, @Param("album")String album,
                        @Param("date")int date, @Param("duration")int duration);

    @Update("UPDATE APP.SONG SET name=#{name}, artist =#{artist}, album =#{album}," +
            "date =#{date}, duration =#{duration} WHERE id =#{id}")
    public void editSong(@Param("id")int id,@Param("name")String name, @Param("artist")String artist,
                         @Param("album")String album, @Param("date")int date, @Param("duration")int duration);

    @Delete("DELETE FROM APP.SONG WHERE id =#{id}")
    void deleteSong(int id);
}