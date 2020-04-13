package com.njuiot.iotcloud.controller;

import com.njuiot.iotcloud.mqtt.Client;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MQTTReceiveController implements ApplicationRunner {

    Client client = null;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        client = new Client();
        client.connect();
    }

    @RequestMapping("/api/mqttsend")
    public boolean MQTTSend(@RequestParam("topic") String topic, @RequestParam("message") String message) throws MqttException {
        if(topic!=null && message!=null) {
            System.out.println(topic);
            System.out.println(message);
            // 发布消息测试
            client.mqttClient.subscribe(topic, 0);
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setQos(0);
            mqttMessage.setRetained(false);
            // 内容
            mqttMessage.setPayload(message.getBytes());
            MqttTopic mqttTopic = client.mqttClient.getTopic(topic);
            client.publish(mqttTopic, mqttMessage);

            return true;
        }
        return false;
    }


}
