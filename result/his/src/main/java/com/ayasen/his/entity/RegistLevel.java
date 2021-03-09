package com.ayasen.his.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistLevel {
    private int ID;
    private String registCode;
    private String registName;
    private int sequenceNo;
    private double registFee;
    private int registQuota;
    private int delMark;
}
