package com.ayasen.his.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientCost {
    private int ID;
    private double price;
    private double payBack;
    private double realPay;
    private String payway;
    private String caseNum;
    private String receiptNum;
    private LocalDateTime payTime;
}
