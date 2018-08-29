package mapper;

import model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    @Select("select * from APP.MESSAGE where id = #{id}")
    public User getUserUsingId(@Param("id") int id);

    @Select("select * from message where command = #{command}")
    public User getUserUsingCommand(@Param("command") String command);
}