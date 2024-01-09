package com.example.Gachon_Its.dto;

import com.example.Gachon_Its.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor  //기본 생성자
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자
public class UserDTO {

    private String userId;

    private String password;

    private String userName;

    private String nickName;

    private String email;

    private MultipartFile postFile; //save.html에서 controller로 넘어올 때 파일 담는 용도

    private String originalFileName; // 원본 파일 이름

    private String storedFileName; //서버 저장용 파일 이름  왜 구분? -> 어제 파일 "내 사진" 올림, 오늘도 "내 사진" 올림 , 두 개가 혼동될 수 있음

    private int fileAttached;

    public UserDTO toSaveDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setNickName(userEntity.getNickName());
        if (userEntity.getFileAttached() == 0) {
            userDTO.setFileAttached(0);
        }else{
            userDTO.setFileAttached(1);
            userDTO.setOriginalFileName(userEntity.getUserImageEntity().getOriginalFileName());
            userDTO.setStoredFileName(userEntity.getUserImageEntity().getStoredFileName());

        }
        return userDTO;
    }

}
