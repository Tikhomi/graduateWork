package com.example.graduateWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.graduateWork.entity.StatusDic;

@Repository
public interface StatusDicRepository extends JpaRepository<StatusDic, Long> {
    StatusDic getStatusDicByIdStatus (Long IdStatus);
}



