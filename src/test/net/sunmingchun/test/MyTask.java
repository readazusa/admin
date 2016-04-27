package net.sunmingchun.test;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * net.sunmingchun.test
 * Created by smc
 * date on 2016/4/11.
 * Email:sunmch@163.com
 */
public class MyTask {
    private static final Logger log = LoggerFactory.getLogger(TestActiviti.class);

    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("activiti/task.bpmn").deploy();
        String deployId = deployment.getId();
        String deployName = deployment.getName();
        System.out.println("deployId: " + deployId + " ,deployName: " + deployName);
        System.out.println("部署成功........");
    }

    @Test
    public void testRun() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey("myTask");
        System.out.println("启动流程成功");
    }

    @Test
    public void startTask() {
        //Task[id=22504, name=smc]
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
//        taskService.
        TaskQuery taskQuery = taskService.createTaskQuery();
//        List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("smc").list();
//        List<Task> tasks = taskService.createTaskQuery().taskAssignee("smcss").list();
////        taskService.createTaskQuery().
//        for (Task task : tasks) {
//            try {
//                System.out.println(task.getName() + " owner:　" + task.getOwner());
//                String taskId = task.getId();
//                taskService.claim(taskId, "smc");
////                taskService.complete(taskId);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
        List<Task> tasks = taskQuery.orderByTaskCreateTime().desc().list();
        for(Task task : tasks){
            String taskId = task.getId();
            System.out.println("taskId: "+ taskId);
            taskService.complete(taskId);
        }


        long taskCount = taskQuery.count();
        System.out.println("count: " + taskCount);
//        taskQuery.active().


//        Task task = taskQuery.singleResult();
//
//        String s = task.toString();
//        String taskId = task.getId();
//        String owner = task.getOwner();
//        System.out.println("taskId: "+ taskId+" ,owner: "+ owner);
//        System.out.println("s:  "+ s);
////        taskService.complete(taskId);
//        System.out.println("执行了任务");
    }

}
