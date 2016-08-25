package net.sunmingchun.www.test.listener;

import net.sunmingchun.www.test.po.ObjInfo;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * net.sunmingchun.www.test.listener
 * Created by smc
 * date on 2016/3/8.
 * Email:sunmch@163.com
 */
public class OneListener implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger(OneListener.class);


    @Override
    public void onMessage(Message message) {
        try {
            log.error("jms获取:  {}",message);
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
