package dao;

import viewmodel.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 12917 on 2017/7/18.
 */
@Repository
public class UserDao {
    @Autowired(required = false)
    private UserMapper userMapper;
    public int  insertUser(User user){
        int i=userMapper.insert(user);
        System.out.println(i);
        return i;
    }
    public User selectUser(String username){
        return userMapper.selectByPrimaryKey(username);
    }
}
