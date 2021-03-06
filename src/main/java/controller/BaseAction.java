package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.AllService;

/**
 * Created by 12917 on 2017/6/11.
 */
@Controller
public class BaseAction {
    public void setAllService(AllService allService) {
        this.allService = allService;
    }

    @Autowired
    private AllService allService;
    public AllService getAllService(){
        return allService;
    }
}
