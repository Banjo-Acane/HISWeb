package com.ayasen.his.dao;

import com.ayasen.his.entity.PaymentInfo;
import com.ayasen.his.entity.PreDrugs;
import com.ayasen.his.entity.Prescription;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionDao {
    public List<Prescription> getPres();
    //public List<PaymentInfo> getPreDetails();
    public List<PaymentInfo> getPayInfo(@Param("medicalID")int medicalID);
    public List<Prescription> getPreTemplates();
    public List<PreDrugs> getPreDrugs(@Param("drugsTempID") int drugsTempID); //获取处方模板内的药品信息
    public void setPayState(@Param("pdID") int pdID);   //将处方中药品装填改为已缴费
}
