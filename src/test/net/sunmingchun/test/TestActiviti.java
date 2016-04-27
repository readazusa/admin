package net.sunmingchun.test;

import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * net.sunmingchun.test
 * Created by smc
 * date on 2016/4/7.
 * Email:sunmch@163.com
 */
public class TestActiviti {
    private static final Logger log = LoggerFactory.getLogger(TestActiviti.class);
    public static void main(String[] args) {
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault().buildProcessEngine();
//        ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration().buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("activiti/MyProcess.bpmn").deploy();
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
//        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().singleResult();
//        log.info("processKey： {}", processDefinition.getKey());


    }


    @Test
    public void startTask(){
        String activitiKey = "myProcess";
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault().buildProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(activitiKey);

        log.info("Number of process instances: " + runtimeService.createProcessInstanceQuery().count());
    }

    @Test
    public void destory(){
        ProcessEngines.destroy();
        System.out.println("===============销毁成功==============");
    }

}
