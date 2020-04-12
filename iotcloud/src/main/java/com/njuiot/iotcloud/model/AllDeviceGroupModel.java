package com.njuiot.iotcloud.model;

import com.njuiot.iotcloud.entity.Device;
import com.njuiot.iotcloud.entity.DeviceGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllDeviceGroupModel {
    public static List<DeviceGroup> allDeviceGroup = new ArrayList<>();

    public AllDeviceGroupModel() {

    }

    public static List<DeviceGroup> getAllDeviceGroup(){
        Device d1 = new Device();
        d1.setName("设备1");
        d1.setUuid("d1");
        d1.setMessages(Arrays.asList("today msg1", "123"));

        Device d2 = new Device();
        d2.setName("设备2");
        d2.setUuid("d2");
        d2.setMessages(Arrays.asList("today msg2", "123"));

        DeviceGroup dp1 = new DeviceGroup();
        dp1.setId(1);
        dp1.setName("设备组1");
        dp1.setAllDevices(Arrays.asList(d1, d2));

        allDeviceGroup.add(dp1);
        return allDeviceGroup;
    }
}
