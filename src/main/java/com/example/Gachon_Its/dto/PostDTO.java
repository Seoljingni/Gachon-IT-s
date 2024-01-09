package com.example.Gachon_Its.dto;

import com.example.Gachon_Its.entity.PostEntity;
import com.example.Gachon_Its.entity.UserEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor  //기본 생성자
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자
@ToString
public class PostDTO {

    private Long postId;

    private String userId;

    private String postTitle;

    private String postContents;

    private LocalDateTime CreatedTime;

    private LocalDateTime UpdatedTime;

    private MultipartFile postFile; //save.html에서 controller로 넘어올 때 파일 담는 용도

    private String originalFileName; // 원본 파일 이름

    private String storedFileName; //서버 저장용 파일 이름  왜 구분? -> 어제 파일 "내 사진" 올림, 오늘도 "내 사진" 올림 , 두 개가 혼동될 수 있음

    private int fileAttached; // 파일 첨부 여부(첨부 1, 아님 0) (boolean으로 하면 나중에 boardEntity할 때 귀찮음)

    public PostEntity toEntity() {      //test
        return new PostEntity(null, postTitle, postContents);
    }

    public PostDTO toSaveDTO(PostEntity postEntity, String userId){
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(postEntity.getPostId());
        postDTO.setUserId(userId);
        postDTO.setPostTitle(postEntity.getPostTitle());
        postDTO.setPostContents(postEntity.getPostContents());
        postDTO.setCreatedTime(postEntity.getCreatedTime());
        postDTO.setUpdatedTime(postEntity.getUpdatedTime());
        if (postEntity.getFileAttached() == 0) {
            postDTO.setFileAttached(0);
        } else {
            postDTO.setFileAttached(postEntity.getFileAttached());
            postDTO.setOriginalFileName(postEntity.getPostImageEntityList().get(0).getOriginalFileName());
            postDTO.setStoredFileName(postEntity.getPostImageEntityList().get(0).getStoredFileName());
        }
        return postDTO;

    }
}
