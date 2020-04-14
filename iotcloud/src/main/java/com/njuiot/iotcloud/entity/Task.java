package com.njuiot.iotcloud.entity;

public class Task {
    String taskName;
    String taskType;
    String taskDescribe;
    String taskCondition;
    String taskDetail;

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", taskType='" + taskType + '\'' +
                ", taskDescribe='" + taskDescribe + '\'' +
                ", taskCondition='" + taskCondition + '\'' +
                ", taskDetail='" + taskDetail + '\'' +
                '}';
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskDescribe() {
        return taskDescribe;
    }

    public void setTaskDescribe(String taskDescribe) {
        this.taskDescribe = taskDescribe;
    }

    public String getTaskCondition() {
        return taskCondition;
    }

    public void setTaskCondition(String taskCondition) {
        this.taskCondition = taskCondition;
    }

    public String getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(String taskDetail) {
        this.taskDetail = taskDetail;
    }
}
