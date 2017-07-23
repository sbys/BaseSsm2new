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
    private InfoService infoService;
    @Autowired
    private SaverService saverService;
    public InfoService getInfoService() {
        return infoService;
    }

    public SaverService getSaverService() {
        return saverService;
    }
}
