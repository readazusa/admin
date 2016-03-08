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
public class TwoListener implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger(TwoListener.class);
    @Override
    public void onMessage(Message message) {
        ActiveMQObjectMessage activeMQObjectMessage = (ActiveMQObjectMessage) message;

        try {
            ObjInfo objInfo = (ObjInfo)activeMQObjectMessage.getObject();
            log.error("线程:{},name:{},no:{}",Thread.currentThread().getName(),objInfo.getName(),objInfo.getNo());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        log.error(message.getClass().getName());
        log.error("message： {}",message);



    }
}
