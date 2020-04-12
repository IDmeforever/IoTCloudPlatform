package com.njuiot.iotcloud.controller;

import com.njuiot.iotcloud.entity.DeviceGroup;
import com.njuiot.iotcloud.model.AllDeviceGroupModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceGroupController {

    @RequestMapping("/api/getAllDeviceGroup")
    public List<DeviceGroup> getAllDeviceGroup(){
        return AllDeviceGroupModel.allDeviceGroup;
    }
}
