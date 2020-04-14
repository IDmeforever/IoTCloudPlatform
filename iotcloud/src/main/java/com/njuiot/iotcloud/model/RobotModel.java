package com.njuiot.iotcloud.model;

import com.njuiot.iotcloud.entity.Robot;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RobotModel implements ApplicationRunner {


    private static List<Robot> robotList;

    public static List<Robot> getAllRobot(){
        return robotList;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        robotList = new ArrayList<>();
        Robot r1 = new Robot();
        r1.setName("包裹机器人1");
        r1.setLng("118.78821");
        r1.setLat("32.058123");
        r1.setStatus("运输中");
        r1.setInfo("南京大学包裹机器人1(宿舍区)");
        robotList.add(r1);

        Robot r2 = new Robot();
        r2.setName("包裹机器人2");
        r2.setLng("118.786297");
        r2.setLat("32.058934");
        r2.setStatus("已抵达");
        r2.setInfo("南京大学包裹机器人2(宿舍区)");
        robotList.add(r2);

        Robot r3 = new Robot();
        r3.setName("包裹机器人3");
        r3.setLng("118.786809");
        r3.setLat("32.061765");
        r3.setStatus("运输中");
        r3.setInfo("南京大学包裹机器人3(教学区)");
        robotList.add(r3);

        System.out.println("初始化成功，机器人数目: "+robotList.size());
    }
}
