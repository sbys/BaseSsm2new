package controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 12917 on 2017/6/11.
 */
@Controller
@Transactional
public class InsertUserinfo  extends BaseAction{
    @RequestMapping(value="insertUserinfo")
    public String insertUserinfo(){
        this.getAllService().getUserinfoService().insertUserinfo(4,"SHABI",5);
        return "index";
    }

}
