package net.sunmingchun.www.test.contrller;

import net.sunmingchun.www.test.service.JmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * net.sunmingchun.www.test.contrller
 * Created by smc
 * date on 2016/3/8.
 * Email:sunmch@163.com
 */
@Controller
@RequestMapping("test/jms")
public class TestJmsController {

    private static final Logger log = LoggerFactory.getLogger(TestJmsController.class);

//    @Resource
    private JmsService jmsService;

    @RequestMapping("start")
    @ResponseBody
    public void start(){

        log.error("开启线程");
//        jmsService.start();
    }

}
