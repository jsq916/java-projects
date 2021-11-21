package com.jsq.service;

import com.jsq.bean.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String addUser(User user){
        return "ok";
    }

}
