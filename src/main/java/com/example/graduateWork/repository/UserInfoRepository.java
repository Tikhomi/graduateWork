package com.example.graduateWork.repository;

import com.example.graduateWork.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo getUserInfoByIdUserInfo(Long idUserInfo);
}