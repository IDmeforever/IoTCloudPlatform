package com.njuiot.iotcloud.controller;

import com.njuiot.iotcloud.entity.DeviceGroup;
import com.njuiot.iotcloud.model.AllDeviceGroupModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceGroupController {

    @RequestMapping("/api/getAllDeviceGroup")
    public List<DeviceGroup> getAllDeviceGroup(){
        return AllDeviceGroupModel.getAllDeviceGroup();
    }

    @RequestMapping("/api/adddashboard")
    public boolean addDashboard(@RequestParam("name") String name, @RequestParam("value") String value) {
        if(name!=null && value!=null) {
            System.out.println("添加了仪表盘: "+name+", 值为: "+value);
            return true;
        }
        return false;
    }
}
