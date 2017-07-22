package dao;

import model.Userpermission;
import model.UserpermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 12917 on 2017/7/18.
 */
@Repository
public class PermissionDao {
    @Autowired
    private UserpermissionMapper userpermissionMapper;
    public void insert(Userpermission userpermission){
        userpermissionMapper.insert(userpermission);
    }
}
