package com.ayasen.his.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private int ID;
    private String deptCode;
    private String deptName;
    private int deptCategoryID;
    private int deptType;
    private int delMark;
}
