package com.ayasen.his.controller;

import com.alibaba.fastjson.JSON;
import com.ayasen.his.dao.MedicalRecordDao;
import com.ayasen.his.entity.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalController {
    @Autowired
    MedicalRecordDao medicalRecordDao;

    @RequestMapping("/medicalRecord")
    public void saveMedicalHistory(@RequestBody MedicalRecord m){
        System.out.println(JSON.toJSONString(m));
        medicalRecordDao.saveMedicalRecord(
                m.getCaseNumber(),m.getID(),m.getMainContent(),m.getPresent(),
                m.getPresentTreat(),m.getHistory(),m.getAllergy(),m.getPhysique(),
                m.getProposal());
    }
}
