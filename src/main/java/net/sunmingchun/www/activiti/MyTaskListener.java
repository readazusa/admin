package net.sunmingchun.www.activiti;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * net.sunmingchun.www.activiti
 * Created by smc
 * date on 2016/4/14.
 * Email:sunmch@163.com
 */
public class MyTaskListener implements TaskListener {

    private static final Logger log = LoggerFactory.getLogger(MyTaskListener.class);
    @Override
    public void notify(DelegateTask delegateTask) {
        String assigne = delegateTask.getAssignee();
        String s = delegateTask.getEventName();
        log.info("ass: {},eventname: {}",assigne,s);
    }
}
