package com.ayasen.his.controller;

import com.alibaba.fastjson.JSON;
import com.ayasen.his.dao.DrugsDao;
import com.ayasen.his.entity.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DrugsController {
    @Autowired
    DrugsDao drugsDao;

    @RequestMapping("/drugs")
    public String getDrugs(){
        List<Drug> depts= drugsDao.getDrugs();
        String res_json = JSON.toJSONString(depts);
        return res_json;
    }
}
