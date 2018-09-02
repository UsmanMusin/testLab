package service;

import mapper.Mapper;
import model.Song;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}