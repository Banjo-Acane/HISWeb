package com.ayasen.his.controller;

import com.alibaba.fastjson.JSON;
import com.ayasen.his.dao.DoctorDao;
import com.ayasen.his.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    DoctorDao doctorDao;
    @RequestMapping("/doctor")
    public String getSelectableDoctor(@RequestBody Doctor doctor){
        List<Doctor> doctors = doctorDao.getDoctorByMessage(doctor.getScheddate(), doctor.getNoon(), doctor.getDeptName());
        String res_JSON = JSON.toJSONString(doctors);
        return res_JSON;
    }
}
