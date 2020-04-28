package com.socketapp.demo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(indexes = {
        @Index(name = "idx_parameter_id_time", columnList = "parameter_id,time")
})

public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "parameter_id")
    private Parameter param;
    private LocalDateTime time;
    private Integer value;

    public Device(){
    }

    public Device(Long id, Parameter param, LocalDateTime time, Integer value) {
        this.id = id;
        this.param = param;
        this.time = time;
        this.value = value;
    }

    public Device(Parameter param, LocalDateTime time, Integer value) {
        this.param = param;
        this.time = time;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Parameter getParam() {
        return param;
    }

    public void setParam(Parameter param) {
        this.param = param;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", param=" + param +
                ", time=" + time +
                ", value=" + value +
                '}';
    }
}
