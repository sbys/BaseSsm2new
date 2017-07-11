package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 12917 on 2017/6/11.
 */
@Repository
public class AllDao {

    public void setUserinfoDao(UserinfoDao userinfoDao) {
        this.userinfoDao = userinfoDao;
    }

    @Autowired
    private UserinfoDao userinfoDao;
    public UserinfoDao getUserinfoDao(){
        return userinfoDao;
    }
}
