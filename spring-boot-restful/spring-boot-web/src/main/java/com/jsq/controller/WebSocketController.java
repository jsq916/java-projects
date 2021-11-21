package com.jsq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsq.service.MyWebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/test")
public class WebSocketController {
    @Autowired
    private MyWebSocket service;

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test() throws JsonProcessingException {
        ObjectMapper gson = new ObjectMapper();
        try {
            MyWebSocket.sendInfo("大家好");//发送消息到clientsocket
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<>();
        map.put("result","Hello");
        return gson.writeValueAsString(map);
    }

}
