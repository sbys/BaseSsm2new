package service;

import dao.AllDao;
import model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 12917 on 2017/6/11.
 */
@Service
@Transactional
public class UserinfoService {
    public AllDao getAllDao() {
        return allDao;
    }
    public void setAllDao(AllDao allDao) {
        this.allDao = allDao;
    }

    @Autowired
    private AllDao allDao;
    public void insertUserinfo(int id,String username,int age){
        Userinfo userinfo=new Userinfo();
        userinfo.setUid(id);
        userinfo.setUname(username);
        userinfo.setAge(age);
        allDao.getUserinfoDao().insertUserinfo(userinfo);

    }
}
