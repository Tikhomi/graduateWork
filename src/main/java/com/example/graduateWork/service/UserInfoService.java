package com.example.graduateWork.service;

import com.example.graduateWork.dto.UserInfoDTO;
import com.example.graduateWork.entity.Appointment;
import com.example.graduateWork.entity.SpecificationDic;
import com.example.graduateWork.entity.UserInfo;
import com.example.graduateWork.entity.Users;
import com.example.graduateWork.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;


    @Autowired
    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public List<UserInfoDTO> getAllUserInfos() {
        List<UserInfo> userInfos = userInfoRepository.findAll();
        return userInfos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserInfoDTO getUserInfoById(Long idUserInfo) {
        UserInfo userInfo= userInfoRepository.getUserInfoByIdUserInfo(idUserInfo);
        if (userInfo != null) {
            return convertToDTO(userInfo);
        }
        return null;
    }

    public UserInfo save(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    public Long delete(Long idUserInfo) {
        userInfoRepository.deleteById(idUserInfo);
        return idUserInfo;
    }

    private UserInfoDTO convertToDTO(UserInfo userInfo) {
        List<Users> userList = userInfo.getUsers()
                .stream()
                .collect(Collectors.toList());

        List<SpecificationDic> specificationDicsList = userInfo.getSpecificationDics()
                .stream()
                .collect(Collectors.toList());

        return new UserInfoDTO(userInfo.getName(), userInfo.getLastname(), userInfo.getPatronymic(),
                userInfo.getBirthday(), userList, specificationDicsList);
    }
}
