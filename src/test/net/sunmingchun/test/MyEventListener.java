package net.sunmingchun.test;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;

/**
 * net.sunmingchun.test
 * Created by smc
 * date on 2016/4/8.
 * Email:sunmch@163.com
 */
public class MyEventListener implements ActivitiEventListener {

    @Override
    public void onEvent(ActivitiEvent event) {
        switch (event.getType()) {

            case JOB_EXECUTION_SUCCESS:
                System.out.println("A job well done!");
                break;

            case JOB_EXECUTION_FAILURE:
                System.out.println("A job has failed...");
                break;

            default:
                System.out.println("Event received: " + event.getType());
        }
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }
}
