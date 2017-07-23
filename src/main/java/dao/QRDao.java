package dao;

import viewmodel.Qr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import mapper.QrMapper;
/*二维码，每一个二维码都有一个唯一id，以及该二维码对应积分*/
@Repository
public class QRDao {
    @Autowired(required = false)
    private QrMapper qrMapper;
    public int insert(Qr qr){
        return qrMapper.insert(qr);
    }
    public Qr select(String str){
        return qrMapper.selectByPrimaryKey(str);
    }
    public int delete(String id){
        return qrMapper.deleteByPrimaryKey(id);
    }

}
