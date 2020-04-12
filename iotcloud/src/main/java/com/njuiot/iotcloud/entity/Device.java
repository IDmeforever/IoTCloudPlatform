package com.njuiot.iotcloud.entity;

import java.util.List;

public class Device {

    private String name;
    private String uuid;
    private List<String> messages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", messages=" + messages +
                '}';
    }
}
