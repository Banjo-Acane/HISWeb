package com.ayasen.his.controller;

import com.alibaba.fastjson.JSON;
import com.ayasen.his.dao.DepartmentDao;
import com.ayasen.his.dao.DoctorDao;
import com.ayasen.his.dao.RegisterDao;
import com.ayasen.his.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class RegisterController {
    @Autowired
    RegisterDao registerDao;
    @Autowired
    DoctorDao doctorDao;
    @Autowired
    DepartmentDao departmentDao;

    //获得挂号等级
    @RequestMapping("/registLevel")
    public String getLevels(){
        List<RegistLevel> res = registerDao.getRegistLevel();
        String res_json = JSON.toJSONString(res);
        return res_json;
    }
    //将新增挂号信息存入数据库
    @RequestMapping("/register")
    public String insertRegister(@RequestBody Register r){
        System.out.println(JSON.toJSONString(r));
        Doctor d = doctorDao.getDoctorByName(r.getDoctorName());
        Department de = departmentDao.getDepartmentByName(r.getDeptName());
        RegistLevel rl = registerDao.getRegistLevelByName(r.getRegistLevel());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String registTime = df.format(now);
        r.setRegistTime(now);
        int isBook;
        if (r.isBook() == false){
            isBook =0;
        }else{
            isBook = 1;
        }
        registerDao.insertRegister(
                r.getRealName(),r.getGender(),r.getHomeAddress(),r.getVisitDate(),
                r.getBirthDate(),r.getNoon(),de.getID(),d.getID(),
                rl.getID(),r.getIDnumber(), r.getCaseNumber(),isBook,
                registTime, r.getAge(),r.getSettle());
        System.out.println(JSON.toJSONString(r));
        return null;
    }
    //获得待诊患者列表
    @RequestMapping("/waitingP")
    public String getWaitingP(@RequestBody Register r){
        System.out.println(r.getUserID());
        List<Register> registers = registerDao.getWaitingPatient(r.getUserID());
        String res_json = JSON.toJSONString(registers);
        System.out.println(res_json);
        return res_json;
    }
    //获得已诊患者列表
    @RequestMapping("diagnosedP")
    public String getDiagnosedP(@RequestBody Register r){
        List<Register> registers = registerDao.getDiagnosedPatient(r.getUserID());
        String res_json = JSON.toJSONString(registers);
        //System.out.println(res_json);
        return res_json;
    }
    //将病人病历修改为已诊状态
    @RequestMapping("/toDiagnosed")
    public void upDateState(@RequestBody Register r){
        registerDao.upDateState(r.getID());
    }

    //通过病历号获取病人信息
    @RequestMapping("/getPatientInfo")
    public String getPatientInfo(@RequestBody Register r){
        Register res = registerDao.getRegisterByCaseNum(r.getCaseNumber());
        if(res!=null){
            if(res.getVisitState() == 1){
                res.setStateName("已挂号");
            }else if(res.getVisitState() == -1){
                res.setStateName("已退号");
            }else if(res.getVisitState() == 2){
                res.setStateName("已诊断");
            }else{
                res.setStateName("已发药");
            }
        }
        String res_json = JSON.toJSONString(res);
        return res_json;
    }
    //获得最大病历号
    @RequestMapping("/caseNumber")
    public String getMaxCaseNumber(){
        String caseNum = registerDao.getMaxCaseNumber();
        int num = Integer.parseInt(caseNum);
        num += 1;
        caseNum = String.valueOf(num);
        return caseNum;
    }
    //退号 修改visitState
    @RequestMapping("/cancel")
    public void cancelByRegisterID(@RequestBody Register r){
        registerDao.cancelRegister(r.getCaseNumber());
    }
}
