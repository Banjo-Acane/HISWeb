package com.ayasen.his.controller;

import com.alibaba.fastjson.JSON;
import com.ayasen.his.dao.DepartmentDao;
import com.ayasen.his.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/departs")
    public String getDeparts(){
        List<Department> depts= departmentDao.getDeparts();
        String res_json = JSON.toJSONString(depts);
        return res_json;
    }
}
