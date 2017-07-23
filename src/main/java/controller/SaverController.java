package controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import viewmodel.JudgeResult;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@Transactional
@RequestMapping(value = "/saver")
public class SaverController {
    /*j接受一个请求上传几张图片，返回boolean结果和一张二维码图片*/
    @RequestMapping(value = "judge", method = RequestMethod.POST)
    @ResponseBody
    public JudgeResult judge() {
        return null;
    }

//    @RequestMapping(value = "file/upload", method = RequestMethod.POST)
//    public String upload(@RequestParam(value = "username", required = false, defaultValue = "sss") String username, @RequestPart("upload") MultipartFile multipartFile, HttpSession httpSession) throws IOException {
//        String filename = multipartFile.getOriginalFilename();
//        String leftPath = "E:\\webr\\images";
//        File file = new File(leftPath, filename);
//        multipartFile.transferTo(file);
//
//        return "/result";
//    }
//@RequestMapping(value = "file/down",method = RequestMethod.GET)
//public ResponseEntity<byte[]> down(@RequestParam("username") String user) throws UnsupportedEncodingException,IOException{
//    File file=new File("E:\\webr\\images\\aaa.jpg");
//    HttpHeaders headers=new HttpHeaders();
//    String filename=new String("aaa.jpg".getBytes("utf-8"),"iso-8859-1");
//    headers.setContentDispositionFormData("attachment",filename);
//    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//    return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
//}
}
