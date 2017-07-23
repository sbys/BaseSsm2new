package service;

import dao.AllDao;
import viewmodel.Phone;
import viewmodel.User;
import viewmodel.UserData;
import viewmodel.Userpermission;
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
            UserData userData=new UserData();
            userData.setUsername(name);
            userData.setIntegral(0);
            userData.setGift(0);
            userData.setGifted(0);
            allDao.getUserDataDao().insert(userData);
            return 1;
        }
        else
            return 0;
    }
    /*增加积分，积分每加50，礼品数加一*/
    public void add(String name){
        UserData userData=allDao.getUserDataDao().select(name);
        int i=userData.getIntegral();
        if(i%50==0){
            int tem=userData.getGift();
            userData.setGift(tem+1);
        }
        userData.setIntegral(i+1);
        allDao.getUserDataDao().update(userData);
    }
    /*处理注册请求发送验证码的请求*/
    public int  putcode(String number){
        /*检查该手机号是否被注册过*/
        User user=allDao.getUserDao().selectUser(number);
        if(user!=null){
            /*手机号已经被注册过*/
            return 0;
        }
        else{
            String code="3";
            /*api 发送*/
            Phone phone=new Phone();
            phone=new Phone();
            phone.setNumber(number);
            phone.setCode(code);
            allDao.getPhoneDao().insert(phone);
            return 1;
        }
    }
    /*带验证码的注册*/
    public int inserUser1(String username,String password,String name,String code){
        Phone phone=allDao.getPhoneDao().select(username);
            if(code.equals(phone.getCode())&&!phone.getCode().equals("0000")) {
                User user = new User();
                user.setUsername(name);
                user.setPassword(password);
                user.setEnable(true);
                allDao.getUserDao().insertUser(user);
                Userpermission userpermission = new Userpermission();
                userpermission.setUsername(name);
                userpermission.setPermission("USER");
                allDao.getPermissionDao().insert(userpermission);
                UserData userData = new UserData();
                userData.setUsername(name);
                userData.setIntegral(0);
                userData.setGift(0);
                userData.setGifted(0);
                allDao.getUserDataDao().insert(userData);
                phone.setCode("0000");
                allDao.getPhoneDao().update(phone);
                return 1;
            }
            else
            {
                return 0;
            }

    }





}
