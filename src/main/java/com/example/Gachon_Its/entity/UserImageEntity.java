package com.example.Gachon_Its.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "userImage")
public class UserImageEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userImageId;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

    @OneToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    public static UserImageEntity toUserImageEntity(UserEntity userEntity, String originalFileName, String storedFileName) {
        UserImageEntity userImageEntity = new UserImageEntity();
        userImageEntity.setUserEntity(userEntity);
        userImageEntity.setStoredFileName(storedFileName);
        userImageEntity.setOriginalFileName(originalFileName);

        return userImageEntity;
    }
}
