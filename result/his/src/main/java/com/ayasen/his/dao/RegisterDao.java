package com.ayasen.his.dao;

import com.ayasen.his.entity.RegistLevel;
import com.ayasen.his.entity.Register;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface RegisterDao {
    public List<RegistLevel> getRegistLevel();
    public RegistLevel getRegistLevelByName(@Param("registName")String registName);
    public void insertRegister(@Param("realName") String realName, @Param("gender") int gender,
                               @Param("homeAddress") String homeAddress, @Param("visitDate") Date visitDate,
                               @Param("birthDate") Date birthDate, @Param("noon") String noon,
                               @Param("deptID") int deptID, @Param("userID") int userID,
                               @Param("registLeID") int registLeID, @Param("IDnumber") String IDnumber,
                               @Param("caseNumber") String caseNumber, @Param("needBook")int needBook,
                               @Param("registerTime")String registerTime, @Param("age")int age,
                               @Param("settle") String settle);
   public List<Register> getWaitingPatient(@Param("userID") int userID);
   public List<Register> getDiagnosedPatient(@Param("userID") int userID);
   public void upDateState(@Param("ID") int ID);
   public Register getRegisterByCaseNum(@Param("caseNumber") String caseNumber);
   public String getMaxCaseNumber();
   public void cancelRegister(@Param("caseNumber")String caseNumber);
}