package com.example.Gachon_Its.controller;

import com.example.Gachon_Its.dto.CommentDTO;
import com.example.Gachon_Its.dto.PostDTO;
import com.example.Gachon_Its.dto.UserDTO;
import com.example.Gachon_Its.entity.UserEntity;
import com.example.Gachon_Its.service.UserPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/userPage")
public class UserPageController {

    private UserPageService userPageService;

    @Autowired
    public UserPageController(UserPageService userPageService) {
        this.userPageService = userPageService;
    }

    // 내가 쓴 글들 가져오기
    @GetMapping("/post")
    public List<PostDTO> findUserPost(@RequestParam String userId) {
        List<PostDTO> userPostDTOList = userPageService.findByUserId(userId);
        return userPostDTOList;
    }

    // 내가 수정할 글 가져오기
    @GetMapping("/updatePost/{postId}")
    public String findUpdatePost(@PathVariable Long postId, Model model) {
        PostDTO byPostId = userPageService.findByPostId(postId);
        model.addAttribute("byPostId", byPostId);
        return "update";
    }

    // 내가 수정한 글 갖고오기
    @PostMapping("/updatePost")
    public PostDTO update(@ModelAttribute PostDTO postDTO, Model model) {
        UserDTO userDTO = findUserInfo(postDTO.getUserId());
        UserEntity userEntity = new UserEntity();
        UserEntity saveEntity = userEntity.toSaveEntity(userDTO);
        userPageService.save(postDTO, saveEntity);
        return postDTO;
    }

    // 내가 쓴 글 삭제
    @GetMapping("/deletePost/{postId}")
    public void deletePost(@PathVariable Long postId) {
        userPageService.deletePost(postId);
    }

    // 내 회원 정보 가져오기
    @GetMapping("/userInfo")
    public UserDTO findUserInfo(@RequestParam String userId) {
        UserDTO userById = userPageService.findUserById(userId);
        return userById;
    }

    // 내 회원 정보 수정


    // 내가 쓴 댓글 가져오기
    @GetMapping("/comment")
    public List<CommentDTO> findUserComment(@RequestParam String userId) {
        List<CommentDTO> commentById = userPageService.findCommentById(userId);
        return commentById;
    }
//
//    // 내가 수정할 댓글 가져오기
//    @GetMapping("/comment/{commentId}")
//    public String findUpdateComment(@PathVariable Long commentId, Model model) {
//        PostDTO byPostId = userPageService.findCommentById(commentId);
//        model.addAttribute("byPostId", byPostId);
//        return "update";
//    }

    // 내가 쓴 댓글 삭제
    @GetMapping("/deleteComment/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        userPageService.deleteComment(commentId);
    }
}
