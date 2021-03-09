package com.ayasen.his.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordDao {
    public void saveMedicalRecord(
            @Param("caseNumber")String caseNumber, @Param("registID")int registID,
            @Param("mainContent")String mainContent, @Param("present") String present,
            @Param("presentTreat")String presentTreat, @Param("history") String history,
            @Param("allergy") String allergy, @Param("physique") String physique,
            @Param("proposal") String proposal
    );
}
