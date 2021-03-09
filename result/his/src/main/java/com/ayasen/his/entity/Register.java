package com.ayasen.his.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {
    private int ID;
    private String caseNumber;
    private String realName;
    private int gender;
    private String IDnumber;
    private Date birthDate;
    private int age;
    private String homeAddress;
    private Date visitDate;
    private String noon;
    private int deptId;
    private String doctorName;
    private int userID;//
    private String registLevel;
    private int registLeID;
    private String settle;
    private boolean isBook; //要不要病历本
    private int needBook;
    private LocalDateTime registTime;
    private String registerTime;
    private int visitState; //诊断阶段
    private String deptName;
    private String stateName;

}
