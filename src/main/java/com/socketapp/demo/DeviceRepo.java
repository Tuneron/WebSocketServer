package com.socketapp.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepo extends CrudRepository<Device, Long> {

    Device findFirstByParamIsOrderByTimeDesc(Parameter param);

}
