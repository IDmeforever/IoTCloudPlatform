package com.njuiot.iotcloud.model;

import com.njuiot.iotcloud.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class AllTasksModel {
    static List<Task> allTask = new ArrayList<>();

    public static List<Task> getAllTask() {
        return allTask;
    }

    public static void addTask(Task task) {
        allTask.add(task);
    }
}
