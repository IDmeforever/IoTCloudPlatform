package com.njuiot.iotcloud.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class Client {
    public static final String HOST = "tcp://116.62.131.37:1883";
    public static final String CLIENTID = "client11";
    public static final String USERNAME = "test";
    public static final String PASSWORD = "test";

    public MqttClient mqttClient;

    public void connect() throws MqttException {
        // 新建客户端实例
        mqttClient = new MqttClient(HOST, CLIENTID, new MemoryPersistence());

        // 连接时参数
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        // 用户密码略
        options.setConnectionTimeout(100);
        options.setKeepAliveInterval(180);
        options.setAutomaticReconnect(true);
        options.setWill("close", "offline".getBytes(), 0, true);

        mqttClient.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable cause) {
                System.out.println("连接断开");
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println("收到消息，主题："+topic);
                System.out.println("收到消息，内容："+message);
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                System.out.println("发布完成");
            }
        });

        mqttClient.connect(options);
        System.out.println("连接成功");
    }

    public void publish(MqttTopic topic, MqttMessage message) throws MqttException {
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
    }

    public static void main(String[] args) throws MqttException {
        Client client = new Client();
        client.connect();
        // 发布消息测试
        String topic = "testTopic";
        client.mqttClient.subscribe(topic, 0);
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setQos(0);
        mqttMessage.setRetained(false);
        // 内容
        String msg = "test MQTT send.";
        mqttMessage.setPayload(msg.getBytes());
        MqttTopic mqttTopic = client.mqttClient.getTopic(topic);
        client.publish(mqttTopic, mqttMessage);
    }


}
