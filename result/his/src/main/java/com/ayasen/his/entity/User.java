package com.ayasen.his.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int ID;
    private String username;
    private String password;
    private String realName;
    private int useType;
    private int docTitleID;     //医生职称ID
    private char isScheduling;  //是否排班
    private int deptID;         //所在科室ID
    private int registLeID;     //挂号级别ID
    private int delMark;        //删除标记

}
