package service;

import dao.AllDao;
import model.User;
import model.Userpermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 12917 on 2017/7/18.
 */
@Service
@Transactional
public class UserService {
    public AllDao getAllDao() {
        return allDao;
    }
    public void setAllDao(AllDao allDao) {
        this.allDao = allDao;
    }

    @Autowired
    private AllDao allDao;

    /*注册方法，完成用户表插入以及权限插入*/
    public void insertUser(int username,String password){
//        User user=new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setEnable(false);
//        allDao.getUserDao().insertUser(user);
//        Userpermission userpermission=new Userpermission();
//        userpermission.setUsername(username);
//        allDao.getPermissionDao().insert(userpermission);
    }
}
