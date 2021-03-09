package com.ayasen.his.controller;

import com.alibaba.fastjson.JSON;
import com.ayasen.his.dao.UserDao;
import com.ayasen.his.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public String login(@RequestBody User user){
        String flag = "failed";
        int type = -1;
        User us = userDao.getUserByMessage(user.getUsername(),user.getPassword());
        if(us!=null){
            flag = "success";
            type = us.getUseType();
        }
        HashMap<String, Object> res = new HashMap<>();
        res.put("flag",flag);
        res.put("user",us);
        res.put("type",type);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }
}
