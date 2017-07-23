package dao;

import viewmodel.UserData;
import mapper.UserDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDataDao {
    @Autowired(required = false)
    private UserDataMapper userDataMapper;
    public int insert(UserData userData){
        return  userDataMapper.insert(userData);
    }
    public UserData select(String name){
        return userDataMapper.select(name);
    }
    public int update(UserData userData){
        return userDataMapper.update(userData);
    }
}
