package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 12917 on 2017/6/11.
 */
@Repository
public class AllDao {
    @Autowired private UserinfoDao userinfoDao;
    @Autowired private UserDao userDao;
    @Autowired private PermissionDao permissionDao;
    @Autowired private UserDataDao  userDataDao;
    @Autowired private QRDao qrDao;
    @Autowired private PhoneDao phoneDao;


    public UserDataDao getUserDataDao() {
        return userDataDao;
    }
    public UserinfoDao getUserinfoDao(){
        return userinfoDao;
    }
    public UserDao getUserDao(){
        return userDao;
    }
    public PermissionDao getPermissionDao() {
        return permissionDao;
    }
    public QRDao getQrDao() {
        return qrDao;
    }
    public PhoneDao getPhoneDao() {
        return phoneDao;
    }
}
