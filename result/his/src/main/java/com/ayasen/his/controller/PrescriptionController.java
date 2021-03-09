package com.ayasen.his.controller;

import com.alibaba.fastjson.JSON;
import com.ayasen.his.dao.PrescriptionDao;
import com.ayasen.his.entity.PaymentInfo;
import com.ayasen.his.entity.PreDrugs;
import com.ayasen.his.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;

@RestController
public class PrescriptionController {
    @Autowired
    PrescriptionDao prescriptionDao;

    @RequestMapping("/pres")
    public String getPres(){
        return null;
    }

    @RequestMapping("/payInfo")
    public String getPayInfo(@RequestBody PaymentInfo paymentInfo){
        int flag = 0;
        System.out.println("要查询的病历号："+paymentInfo.getMedicalID());
        List<PaymentInfo> allPayInfos = prescriptionDao.getPayInfo(paymentInfo.getMedicalID());
        //flag=1 表示该病历号对应患者记录存在
        if(!allPayInfos.isEmpty()){
            flag = 1;
        }
        HashMap<String, Object> res = new HashMap<>();
        for(PaymentInfo info:allPayInfos){
            if(info.getState()==2){
                info.setPrice(info.getDrugsPrice()*info.getAmount());
                flag = 2;
            }

        }
        res.put("Info",allPayInfos);
        res.put("flag",flag);
        String res_json = JSON.toJSONString(res);
        System.out.println(res_json);
        return res_json;
    }

    @RequestMapping("preTemp")
    public String getPreTemplates(){
        List<Prescription> pres = prescriptionDao.getPreTemplates();
        String res_json = JSON.toJSONString(pres);
        return res_json;
    }
    @RequestMapping("preTD")
    public String getPreTemp(@RequestBody PreDrugs predrugs){
        List<PreDrugs> pd = prescriptionDao.getPreDrugs(predrugs.getDrugsTempID());
        String res_json = JSON.toJSONString(pd);
        System.out.println(res_json);
        return res_json;
    }

    @RequestMapping("changeState")
    public String setPayState(@RequestBody List<PaymentInfo> list){
        System.out.println(JSON.toJSONString(list));
      for(int i = 0;i<list.size();i++){
          prescriptionDao.setPayState(list.get(i).getPdID());
      }
      return "success";
    }
}
