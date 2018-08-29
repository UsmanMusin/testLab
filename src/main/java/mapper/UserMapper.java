package mapper;

import model.Song;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    @Select("select * from APP.SONG where id = #{id}")
    public Song getSongById(@Param("id") int id);

    @Select("select * from message where command = #{command}")
    public Song getUserUsingCommand(@Param("command") String command);
}