package controller;
import viewmodel.Response;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 12917 on 2017/6/11.
 */
@Controller
@Transactional
@RequestMapping(value = "/app")
public class Info extends BaseAction{
    /*路由到登陆页面*/
    @RequestMapping(value = "/login")
    public String login(){
        return "public/login";
    }
    /*路由到登出页面*/
    @RequestMapping(value = "/logout")
    public String logout(){
        return "public/logout";
    }
    /*注册页面，返回成功或失败*/
    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestParam("username") String username,@RequestParam(value = "password") String password){
        System.out.println(username+password);
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String s=bCryptPasswordEncoder.encode(password);
        int i=this.getAllService().getInfoService().inserUser(username,s);
        if(i==1){
            return "success";
        }
        else
            return "failed";
    }
    /*带验证码的注册页面*/
    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    @ResponseBody
    public Response register2(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("name") String name,@RequestParam("code") String code ){
        Response response=new Response();
        int result=getAllService().getInfoService().inserUser1(username,password,name,code);
        if(result==1)
            response.setResult("success");
        else
            response.setResult("failed");
        return response;
    }

    /*积分增加*/
    @RequestMapping(value = "add")
    @ResponseBody
    public String add(@RequestParam("username")String name){
        this.getAllService().getInfoService().add(name);
        return "success";
    }
    /*请求验证码*/
    @RequestMapping(value = "getcode")
    @ResponseBody
    public Response code(@RequestParam("number") String number){
        int result=this.getAllService().getInfoService().putcode(number);
        Response response=new Response();
        if(result==1)
            response.setResult("发送成功");
        else
            response.setResult("失败");
        return  response;
    }



}
