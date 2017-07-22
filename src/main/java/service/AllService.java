package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by 12917 on 2017/6/11.
 */
@Service
public class AllService {
    @Autowired
    private UserinfoService userinfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private InfoService infoService;
    public UserinfoService getUserinfoService(){
        return userinfoService;
    }
    public UserService getUserService() {
        return userService;
    }
    public InfoService getInfoService() {
        return infoService;
    }
}
