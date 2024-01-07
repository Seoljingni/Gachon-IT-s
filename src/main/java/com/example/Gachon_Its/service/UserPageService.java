package com.example.Gachon_Its.service;

import com.example.Gachon_Its.dto.CommentDTO;
import com.example.Gachon_Its.dto.PostDTO;
import com.example.Gachon_Its.dto.UserDTO;
import com.example.Gachon_Its.entity.CommentEntity;
import com.example.Gachon_Its.entity.PostEntity;
import com.example.Gachon_Its.entity.UserEntity;
import com.example.Gachon_Its.repository.CommentRepository;
import com.example.Gachon_Its.repository.PostImageRepository;
import com.example.Gachon_Its.repository.PostRepository;
import com.example.Gachon_Its.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserPageService {

    private PostRepository postRepository;

    private PostImageRepository postImageRepository;

    private CommentRepository commentRepository;

    private UserRepository userRepository;

    @Autowired
    public UserPageService(PostRepository postRepository, PostImageRepository postImageRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.postImageRepository = postImageRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    // userId로 유저가 쓴 글 다 가져오기
    @Transactional // 부모 entity가 에서 자식 entity를 호출할 때는 붙여줘야됨
    public List<PostDTO> findByUserId(String userId) {
        List<PostEntity> byUserId = postRepository.findByUserEntityUserId(userId);
        List<PostDTO> postDTOList = new ArrayList<>();
        for (PostEntity postEntity : byUserId) {
            PostDTO postDTO = new PostDTO();
            postDTOList.add(postDTO.toSaveDTO(postEntity, userId));
        }
        return postDTOList;
    }

    // postId로 글 가져오기
    public PostDTO findByPostId(Long postId) {
        Optional<PostEntity> postEntity = postRepository.findById(postId);
        PostDTO postDTO = new PostDTO();
        PostDTO saveDTO = postDTO.toSaveDTO(postEntity.get(), postEntity.get().getUserEntity().getUserId());
        return saveDTO;
    }

    public Long save(PostDTO postDTO, UserEntity userEntity) {
        PostEntity postEntity = new PostEntity();
        PostEntity saveEntity = postEntity.toSaveEntity(postDTO, userEntity);
        postRepository.save(saveEntity);
        return postDTO.getPostId();
    }

    public UserDTO findUserById(String userId) {
        Optional<UserEntity> byId = userRepository.findById(userId);
        UserDTO userDTO = new UserDTO();
        UserDTO saveDTO = userDTO.toSaveDTO(byId.get());
        return saveDTO;
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    public List<CommentDTO> findCommentById(String userId) {
        List<CommentEntity> commentEntityList = commentRepository.findByUserEntityUserId(userId);
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for (CommentEntity commentEntity : commentEntityList) {
            CommentDTO commentDTO = new CommentDTO();
            commentDTOList.add(commentDTO.toSaveDTO(commentEntity, userId, commentEntity.getPostEntity().getPostId()));
        }
        return commentDTOList;
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
//    // 유저가 글 작성한거 저장
//    public void save(PostDTO postDTO, UserEntity userEntity) {
//        PostEntity postEntity = new PostEntity();
//        postEntity.toSaveEntity(postDTO, userEntity);
//        postRepository.save(postEntity);
//    }

    // 유저 회원 정보 가져오기
    


}
