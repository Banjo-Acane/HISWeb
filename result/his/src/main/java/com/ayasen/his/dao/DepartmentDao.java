package com.ayasen.his.dao;

import com.ayasen.his.entity.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {
    public List<Department> getDeparts();
    public Department getDepartmentByName(@Param("deptName")String deptName);
}
