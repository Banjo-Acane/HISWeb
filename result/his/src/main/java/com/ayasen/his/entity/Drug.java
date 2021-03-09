package com.ayasen.his.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drug {
    private int ID;
    private String drugsCode;
    private String drugsName;
    private String drugsFormat;
    private String drugsUnit;
    private String Manufacturer;
    private int drugsDosageID;
    private int drugsTypeID;
    private double drugsPrice;
    private String mnemonicCode;
    private LocalDateTime lastUpdateDate;
    private LocalDateTime creationDate;
    private int drugsAmount;
    private String drugsUsage;
    private String drugsFrequency;
}
