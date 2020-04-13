package com.njuiot.iotcloud.controller;

import com.njuiot.iotcloud.entity.Device;
import com.njuiot.iotcloud.entity.DeviceGroup;
import com.njuiot.iotcloud.model.AllDeviceGroupModel;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class ModifiedDeviceGroupController {

    @CrossOrigin
    @PostMapping(value = "api/modifieddevicegroup")
    @ResponseBody
    public boolean EditDeviceGroup(@RequestBody DeviceGroup deviceGroup){
        if(deviceGroup!=null) {
            int id = deviceGroup.getId();
            for(DeviceGroup dg: AllDeviceGroupModel.getAllDeviceGroup()) {
                if(dg.getId() == id) {
                    dg.setName(deviceGroup.getName());
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @CrossOrigin
    @PostMapping(value = "api/adddevicegroup")
    @ResponseBody
    public boolean addDeviceGroup(@RequestBody DeviceGroup deviceGroup){
        if(deviceGroup!=null) {
            System.out.println(deviceGroup);
            AllDeviceGroupModel.getAllDeviceGroup().add(deviceGroup);
            System.out.println(AllDeviceGroupModel.getAllDeviceGroup().size());
            return true;
        }
        return false;
    }

    @RequestMapping("/api/deldevicegroup")
    public boolean delDeviceGroup(@RequestParam("id") Integer id) {
        if(id != null) {
            List<DeviceGroup> lists = AllDeviceGroupModel.getAllDeviceGroup();
            Iterator<DeviceGroup> iterator = lists.iterator();
            while (iterator.hasNext()) {
                if(iterator.next().getId().equals(id)) {
                    iterator.remove();
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
