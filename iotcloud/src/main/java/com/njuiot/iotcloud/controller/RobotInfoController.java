package com.njuiot.iotcloud.controller;

import com.njuiot.iotcloud.entity.Robot;
import com.njuiot.iotcloud.model.RobotModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RobotInfoController {

    @RequestMapping("/api/getallrobots")
    public List<Robot> getAllRobots() {
        System.out.println("获取所有机器人信息，长度："+RobotModel.getAllRobot().size());
        return RobotModel.getAllRobot();
    }
}
