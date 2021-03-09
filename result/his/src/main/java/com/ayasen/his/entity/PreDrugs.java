package com.ayasen.his.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreDrugs {
    private int ID;
    private int drugsTempID;
    private int drugsID;
    private String drugsUsage;
    private String dosage;
    private String frequency;
    private String drugsName;
    private double drugsPrice;
    private String drugsFormat;
}
