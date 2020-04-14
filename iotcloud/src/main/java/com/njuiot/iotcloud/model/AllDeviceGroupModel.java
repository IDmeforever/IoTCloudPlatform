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

    public static List<String> getAllMsgs(){
        getAllDeviceGroup();
        List<String> allmsg = new ArrayList<>();
        for(DeviceGroup deviceGroup: allDeviceGroup) {
            allmsg.addAll(deviceGroup.getAllMessages());
        }
        return allmsg;
    }

    public static List<DeviceGroup> getAllDeviceGroup(){
        if(allDeviceGroup.size()==0) {
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

            Device d3 = new Device();
            d3.setName("温度传感器1");
            d3.setUuid("d3");
            d3.setMessages(Arrays.asList("温度25度", "温度26度"));

            Device d4 = new Device();
            d4.setName("湿度传感器2");
            d4.setUuid("d4");
            d4.setMessages(Arrays.asList("湿度30", "湿度40"));

            Device d5 = new Device();
            d5.setName("加速度传感器");
            d5.setUuid("d5");
            d5.setMessages(Arrays.asList("加速度1", "加速度2"));

            DeviceGroup dp2 = new DeviceGroup();
            dp2.setId(2);
            dp2.setName("设备组2");
            dp2.setAllDevices(Arrays.asList(d3, d4, d5));

            allDeviceGroup.add(dp2);
        }
        return allDeviceGroup;
    }
}
