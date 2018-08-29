package service;

import mapper.UserMapper;
import model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Song getUserUsingId(String id) {
        System.out.println(userMapper.getSongById(Integer.parseInt(id)).toString());
        return userMapper.getSongById(Integer.parseInt(id));
    }
}