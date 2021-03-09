package com.ayasen.his.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfo {
    private int medicalID;
    private int pdID;
    private String realName;
    private String IDnumber;
    private String homeAddress;
    private String drugsName;
    private double drugsPrice;
    private int amount;
    private LocalDateTime prescriptionTime;
    private int state;
    private int userID;
    private int caseNum;
    private double price; //total price
}
