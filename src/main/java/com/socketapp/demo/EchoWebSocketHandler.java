package com.socketapp.demo;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class EchoWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    DeviceRepo deviceRepo;
    @Autowired
    Gson gson;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Message json = gson.fromJson(message.getPayload(), Message.class);

        Boolean opt = deviceRepo.findById(json.getDeviceId()).isPresent();

        Device device = null;

        if(opt) {
             device =  deviceRepo.findById(json.getDeviceId()).get();
        }
        else {
             device =  new Device(json.getDeviceId(), Parameter.DEVICE, LocalDateTime.now(), 1);
        }

        device.setValue(device.getValue() + 1);

        Message sendMessage = new Message(json.getDeviceId(), (long) device.getValue());

        deviceRepo.save(device);

        session.sendMessage(new TextMessage(gson.toJson(sendMessage)));
    }

    @Bean
    public Gson gson( ) {
        return new Gson();
    }

}