package com.ayasen.his.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    private int ID;
    private String realName;
    private String scheddate;
    private String noon;
    private String deptName;
}
