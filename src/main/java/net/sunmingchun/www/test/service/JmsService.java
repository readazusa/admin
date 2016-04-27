package net.sunmingchun.www.test.service;

import net.sunmingchun.www.test.po.ObjInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * net.sunmingchun.www.test
 * Created by smc
 * date on 2016/3/8.
 * Email:sunmch@163.com
 */
@Service
public class JmsService {

    private static final Logger log = LoggerFactory.getLogger(JmsService.class);

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

//    @Resource
    private JmsTemplate jmsTemplate;

    public void start() {
//        threadPoolTaskExecutor.execute(new Jms());
        jmsTemplate.convertAndSend(Thread.currentThread().getName() + "  测试mq");
        System.out.println("==========成功====================");
    }

    private class Jms implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {

//                ObjInfo objInfo = new ObjInfo(Thread.currentThread().getName(), Thread.currentThread().getName() + i);
                jmsTemplate.convertAndSend(Thread.currentThread().getName() + i);
                if(i%1000 ==0){
                    log.error("执行了1000次的时间: {}",new Date());
                }
            }
        }
    }



}
