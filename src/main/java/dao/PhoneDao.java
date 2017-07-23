package dao;


import mapper.PhoneMapper;
import viewmodel.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*s手机号的访问
* 注册请求发送验证码把手机号存入，生成验证码存入，注册时判断验证码是否一致*/
@Repository
public class PhoneDao {
    @Autowired(required = false)
    private PhoneMapper phoneMapper;
    /*插入手机号*/
    public int insert(Phone phone){
        return phoneMapper.insert(phone);
    }
    /*查看是否存在*/
    public Phone select(String number){
        return  phoneMapper.selectByPrimaryKey(number);
    }
    /*更新验证码*/
    public int  update(Phone phone){
        return phoneMapper.updateByPrimaryKey(phone);
    }
}
