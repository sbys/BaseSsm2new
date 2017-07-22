package service;

import dao.AllDao;
import model.User;
import model.UserMapper;
import model.Userpermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 12917 on 2017/7/20.
 * 注册登陆模块
 */
@Service
@Transactional
public class InfoService {
    @Autowired
    AllDao allDao;
    /*注册，判断用户名是否存在*/
    public int inserUser(String name,String password){
        User user=allDao.getUserDao().selectUser(name);
        if(user==null)
        {
            User user1=new User();
            user1.setUsername(name);
            user1.setPassword(password);
            user1.setEnable(true);
            allDao.getUserDao().insertUser(user1);
            Userpermission userpermission=new Userpermission();
            userpermission.setUsername(name);
            userpermission.setPermission("USER");
            allDao.getPermissionDao().insert(userpermission);
            return 1;
        }
        else
            return 0;
    }


}
