package net.sunmingchun.www.mq.activemq.listener;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by 念梓  on 2016/8/25.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
public class ShopCartListener implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger(ShopCartListener.class);

    @Override
    public void onMessage(Message message) {
        try {
            log.debug("初始化的type: {}",message.getJMSType());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        ActiveMQTextMessage activeMQObjectMessage = (ActiveMQTextMessage) message;
        log.debug("jmsType:{} ", activeMQObjectMessage.getJMSType());
        try {
            String itemId =  activeMQObjectMessage.getText();
            log.info("itemId: {}",itemId);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
