package com.example.Gachon_Its.entity;

import com.example.Gachon_Its.dto.PostDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "post")
public class PostEntity extends BaseEntity{

    @Id     //pk(primary key)로 지정 , DB의 식별자
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long postId;

    @Column
    private String postTitle;

    @Column(length = 500)
    private String postContents;

    @Column
    private int fileAttached; // 1 or 0

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "postEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PostImageEntity> postImageEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "postEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "postEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PostLikeEntity> postLikeEntityList = new ArrayList<>();

    // 게시물 사진 없음
    public static PostEntity toSaveEntity(PostDTO postDTO, UserEntity userEntity) {
        PostEntity postEntity = new PostEntity();
        postEntity.setPostId(postDTO.getPostId());
        postEntity.setUserEntity(userEntity);
        postEntity.setPostTitle(postEntity.getPostTitle());
        postEntity.setPostContents(postEntity.getPostContents());
        postEntity.setFileAttached(0); //파일 없음
        return postEntity;

    }

    // 게시물 사진 있음
    public static PostEntity toSaveFileEntity(PostDTO postDTO, UserEntity userEntity) {
        PostEntity postEntity = new PostEntity();
        postEntity.setPostId(postDTO.getPostId());
        postEntity.setUserEntity(userEntity);
        postEntity.setPostTitle(postEntity.getPostTitle());
        postEntity.setPostContents(postEntity.getPostContents());
        postEntity.setFileAttached(1); //파일 있음
        return postEntity;

    }


}
