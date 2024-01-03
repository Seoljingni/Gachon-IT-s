package com.example.Gachon_Its.dto;

import com.example.Gachon_Its.entity.CommentEntity;
import com.example.Gachon_Its.entity.PostEntity;
import com.example.Gachon_Its.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor  //기본 생성자
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자
public class CommentDTO {

    private Long commentId;

    private Long postId;

    private String userId;

    private String commentContents;

    private LocalDateTime CreatedTime;

    private LocalDateTime UpdatedTime;

    public CommentDTO toSaveDTO(CommentEntity commentEntity, String userId, Long postId) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(commentEntity.getCommentId());
        commentDTO.setPostId(postId);
        commentDTO.setUserId(userId);
        commentDTO.setCommentContents(commentEntity.getCommentContents());
        commentDTO.setCreatedTime(commentEntity.getCreatedTime());
        commentDTO.setUpdatedTime(commentEntity.getUpdatedTime());

        return commentDTO;
    }


}
