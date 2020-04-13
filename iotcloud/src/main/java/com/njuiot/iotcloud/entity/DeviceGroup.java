package com.njuiot.iotcloud.entity;

import java.util.ArrayList;
import java.util.List;

public class DeviceGroup {
    private Integer id;
    private String name;
    private List<Device> allDevices;

    public List<String> getAllMessages() {
        List<String> allMsg = new ArrayList<>();
        if(allDevices != null && allDevices.size()>0) {
            for (Device d : allDevices) {
                allMsg.addAll(d.getMessages());
            }
        }
        return allMsg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getAllDevices() {
        return allDevices;
    }

    public void setAllDevices(List<Device> allDevices) {
        this.allDevices = allDevices;
    }

    @Override
    public String toString() {
        return "DeviceGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", allDevices=" + allDevices +
                '}';
    }
}
