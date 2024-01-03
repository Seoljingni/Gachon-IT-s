package com.example.Gachon_Its.entity;

import com.example.Gachon_Its.dto.CommentLikeDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "commentLike")
public class CommentLikeEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentLikeId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "commentId")
    private CommentEntity commentEntity;

    public static CommentLikeEntity toSaveEntity(CommentLikeDTO commentLikeDTO, UserEntity userEntity, CommentEntity commentEntity) {
        CommentLikeEntity commentLikeEntity = new CommentLikeEntity();
        commentLikeEntity.setCommentLikeId(commentLikeDTO.getCommentLikeId());
        commentLikeEntity.setUserEntity(userEntity);
        commentLikeEntity.setCommentEntity(commentEntity);
        return commentLikeEntity;
    }

}
