package net.sunmingchun.www.base.service;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * net.sunmingchun.www.base.service
 * Created by smc
 * date on 2016/3/3.
 * Email:sunmch@163.com
 */
@Service
public class TheadService {

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    private IBaseTheadService baseTheadService;

    public void execute(IBaseTheadService baseTheadService,Object obj){
        this.baseTheadService = baseTheadService;
        threadPoolTaskExecutor.execute(new ExecuteThread(obj));
    }
    private class ExecuteThread implements  Runnable{
        private Object obj;
        private  ExecuteThread(Object obj){
            this.obj = obj;
        }
        @Override
        public void run() {
            baseTheadService.execute(obj);
        }
    }
}
