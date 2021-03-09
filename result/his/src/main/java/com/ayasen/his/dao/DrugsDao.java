package com.ayasen.his.dao;

import com.ayasen.his.entity.Drug;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugsDao {
    public List<Drug> getDrugs();
}
