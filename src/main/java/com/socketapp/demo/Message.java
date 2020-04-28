package com.socketapp.demo;

public class Message {
    private Long deviceId;
    private Long value;

    public Message() {
    }

    public Message(Long deviceId, Long value) {
        this.deviceId = deviceId;
        this.value = value;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
