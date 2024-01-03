package com.example.Gachon_Its.entity;

import com.example.Gachon_Its.dto.CommentDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "comment")
public class CommentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column
    private String commentContents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    private PostEntity postEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "commentEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentLikeEntity> commentLikeEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "commentEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ChildCommentEntity> childCommentEntityList = new ArrayList<>();

    public static CommentEntity toSaveEntity(CommentDTO commentDTO, UserEntity userEntity, PostEntity postEntity) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentId(commentDTO.getCommentId());
        commentEntity.setCommentContents(commentDTO.getCommentContents());
        commentEntity.setUserEntity(userEntity);
        commentEntity.setPostEntity(postEntity);
        return commentEntity;
    }
}
