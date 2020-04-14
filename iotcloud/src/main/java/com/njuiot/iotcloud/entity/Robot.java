package com.njuiot.iotcloud.entity;

public class Robot {
    String name;
    String lng;
    String lat;
    String status;
    String info;

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", status='" + status + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
