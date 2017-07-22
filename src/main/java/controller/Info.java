package controller;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by 12917 on 2017/6/11.
 */
@Controller
@Transactional
public class Info extends BaseAction{
    /*设置根页面*/
    @RequestMapping(value = "/")
    public String index(){
        return "/jsp/index";
    }
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

    /*写一个账号密码管理界面，有添加，删除方法*/



    @RequestMapping(value="show",method = RequestMethod.GET)
    public String can(@RequestParam ("a") String a,@RequestParam(value = "b",required = false,defaultValue = "sss") String b){
        System.out.print(a+b);
        return "/index";
    }
    @RequestMapping(value = "in",consumes = {"text/json","application/json"},produces = {"text/json","application/json"})
    public String song(){
        return "/index.jsp";
    }
    @RequestMapping(value = "file/upload",method = RequestMethod.POST)
    public String upload(@RequestParam(value = "username",required = false,defaultValue = "sss") String username, @RequestPart("upload") MultipartFile multipartFile,HttpSession httpSession)throws IOException{
        String filename=multipartFile.getOriginalFilename();
        String leftPath="E:\\webr\\images";
        File file=new File(leftPath,filename);
        multipartFile.transferTo(file);

        return "/result";
    }
    @RequestMapping(value = "file/down",method = RequestMethod.GET)
    public ResponseEntity<byte[]> down(@RequestParam("username") String user) throws UnsupportedEncodingException,IOException{
        File file=new File("E:\\webr\\images\\aaa.jpg");
        HttpHeaders headers=new HttpHeaders();
        String filename=new String("aaa.jpg".getBytes("utf-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment",filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
    }


}
