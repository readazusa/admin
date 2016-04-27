package net.sunmingchun.test;

import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

import java.util.List;

/**
 * net.sunmingchun.test
 * Created by smc
 * date on 2016/4/8.
 * Email:sunmch@163.com
 */
public class QjActiviti {
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("activiti/qj.bpmn").deploy();
        System.out.println("部署流程成功");
    }

    @Test
    public void startRun(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
//        runtimeService.
//        ProcessInstance processInstance =  runtimeService.startProcessInstanceById("qj:1:20003");
        runtimeService.startProcessInstanceByKey("qj");
//        processEngine.getName()
        System.out.println("开启了任务");
    }


    @Test
    public void startTask(){
        //Task[id=22504, name=smc]
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
//        taskService.
        TaskQuery taskQuery = taskService.createTaskQuery();
//        List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("kermit").list();
        Task task = taskQuery.singleResult();
        String s = task.toString();
        String taskId = task.getId();
        String owner = task.getOwner();
        System.out.println("taskId: "+ taskId+" ,owner: "+ owner);
        System.out.println("s:  "+ s);
        taskService.complete(taskId);
        System.out.println("执行了任务");
    }



}
