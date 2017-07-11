package dao;

import model.Userinfo;
import model.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 12917 on 2017/6/11.
 */
@Repository
public class UserinfoDao {
    @Autowired
    private UserinfoMapper userinfoMapper;
    public UserinfoMapper getUserinfoMapper() {
        return userinfoMapper;
    }

    public void setUserinfoMapper(UserinfoMapper userinfoMapper) {
        this.userinfoMapper = userinfoMapper;
    }
    public void insertUserinfo(Userinfo userinfo){
        userinfoMapper.insert(userinfo);
    }


}
