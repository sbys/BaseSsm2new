package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 12917 on 2017/6/11.
 */
@Service
public class AllService {
    public void setUserinfoService(UserinfoService userinfoService) {
        this.userinfoService = userinfoService;
    }

    @Autowired
    private UserinfoService userinfoService;
    public UserinfoService getUserinfoService(){
        return userinfoService;
    }
}
