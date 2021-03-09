package com.ayasen.his.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDetailed {
    private int ID;
    private int prescriptionID;
    private String drugsUsage;
    private String dosage;
    private String frequency;
    private int amount;
    private int state;
}
