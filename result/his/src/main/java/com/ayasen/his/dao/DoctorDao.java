package com.ayasen.his.dao;

import com.ayasen.his.entity.Doctor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorDao {
    public List<Doctor> getDoctorByMessage(@Param("scheddate") String scheddate, @Param("noon") String noon, @Param("deptName") String deptName);
    public Doctor getDoctorByName(@Param("realName") String realName);
}
