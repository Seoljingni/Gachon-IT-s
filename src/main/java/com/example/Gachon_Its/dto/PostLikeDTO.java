package com.example.Gachon_Its.dto;

import com.example.Gachon_Its.entity.PostEntity;
import com.example.Gachon_Its.entity.PostLikeEntity;
import com.example.Gachon_Its.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor  //기본 생성자
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자
public class PostLikeDTO {

    private Long postLikeId;

    private String userId;

    private Long postId;

    public static PostLikeDTO toSaveDTO(PostLikeEntity postLikeEntity, UserEntity userEntity, PostEntity postEntity) {
        PostLikeDTO postLikeDTO = new PostLikeDTO();
        postLikeDTO.setPostLikeId(postLikeEntity.getPostLikeId());
        postLikeDTO.setUserId(userEntity.getUserId());
        postLikeDTO.setPostId(postEntity.getPostId());
        return postLikeDTO;
    }
}
