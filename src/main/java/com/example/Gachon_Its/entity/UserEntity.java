package com.example.Gachon_Its.entity;

import com.example.Gachon_Its.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user")
public class UserEntity {

    @Id
    private String userId;

    @Column
    private String password;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private int fileAttached;   // 1 or 0

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PostEntity> postEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private UserImageEntity userImageEntity;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PostLikeEntity> postLikeEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentLikeEntity> commentLikeEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ChildCommentEntity> childCommentEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ChildCommentLikeEntity> childCommentLikeEntityList = new ArrayList<>();

    // 프사 없음
    public static UserEntity toSaveEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setFileAttached(0);
        return userEntity;
    }

    // 프사 있음
    public static UserEntity toSaveFileEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setFileAttached(1);  // 파일 있음
        return userEntity;
    }
}
