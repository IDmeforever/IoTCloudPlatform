package com.njuiot.iotcloud.controller;

import com.njuiot.iotcloud.entity.DeviceGroup;
import com.njuiot.iotcloud.entity.Task;
import com.njuiot.iotcloud.model.AllDeviceGroupModel;
import com.njuiot.iotcloud.model.AllTasksModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class addTaskController {


    @CrossOrigin
    @PostMapping(value = "api/addtask")
    @ResponseBody
    public boolean addTask(@RequestBody Task task){
        if(task!=null) {
            System.out.println(task);
            ExecuteTask(task);
            // 添加进入任务池中
            AllTasksModel.addTask(task);
            System.out.println("任务池任务数量: "+AllTasksModel.getAllTask().size());
            return true;
        }
        return false;
    }

    /**
     * 假设执行任务的接口，以便后续扩展，这里只做显示用
     * @param task
     */
    public void ExecuteTask(Task task) {
        System.out.println("=============新增任务=============");
        System.out.println("> 任务名称: "+task.getTaskName());
        String type = "";
        StringBuilder stringBuilder = new StringBuilder();
        String[] params = task.getTaskCondition().split(",");
        if(task.getTaskType().equals("taskType1")){
            type="定时任务";
            stringBuilder.append("定时日期: ").append(params[0])
                    .append(", 时间: ").append(params[1]);
        } else if(task.getTaskType().equals("taskType2")) {
            type="间隔时间任务";
            stringBuilder.append("间隔时长: ").append(params[0])
                    .append("小时 ").append(params[1]).append("分钟 ")
                    .append(params[2]).append("秒");
        } else {
            type="触发任务";
            stringBuilder.append("触发条件: ");
            if(params[0].equals("1")){
                stringBuilder.append("温度传感器 ");
            } else if(params[0].equals("2")){
                stringBuilder.append("湿度传感器 ");
            } else if(params[0].equals("3")){
                stringBuilder.append("加速度传感器 ");
            }
            if(params[1].equals("1")){
                stringBuilder.append("高于 ");
            } else if(params[1].equals("2")){
                stringBuilder.append("低于 ");
            } else if(params[1].equals("3")){
                stringBuilder.append("等于 ");
            }
            stringBuilder.append(params[2]);
        }
        System.out.println("> 任务类型: "+type);
        System.out.println("> 任务描述: "+task.getTaskDescribe());
        System.out.println("> 任务条件: "+stringBuilder.toString());
        System.out.println("> 任务详情: "+task.getTaskDetail());
        System.out.println("=================================");
    }
}
