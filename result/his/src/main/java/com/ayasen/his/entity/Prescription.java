package com.ayasen.his.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    private int ID;
    private int medicalID;
    private int registID;
    private int userID;
    private String name;
    private LocalDateTime prescriptionTime;
    private int prescriptionState;
    private int scope;
    private String deptName;
}
