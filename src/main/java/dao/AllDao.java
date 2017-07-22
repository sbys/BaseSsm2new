package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 12917 on 2017/6/11.
 */
@Repository
public class AllDao {
    @Autowired private UserinfoDao userinfoDao;
    @Autowired UserDao userDao;
    @Autowired PermissionDao permissionDao;
    public UserinfoDao getUserinfoDao(){
        return userinfoDao;
    }
    public UserDao getUserDao(){
        return userDao;
    }
    public PermissionDao getPermissionDao() {
        return permissionDao;
    }
}
