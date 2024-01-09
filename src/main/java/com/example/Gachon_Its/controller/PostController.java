package com.example.Gachon_Its.controller;

import com.example.Gachon_Its.dto.PostDTO;
import com.example.Gachon_Its.entity.PostEntity;
import com.example.Gachon_Its.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@Slf4j
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/post")
    public String createForm() {
        return "post/createPostForm";
    }

    @PostMapping("post/createPostForm")
    public String createPost(PostDTO form) {
        log.info(form.toString());

        PostEntity post = form.toEntity();
        log.info(post.toString());

        PostEntity saved = postRepository.save(post);
        log.info(saved.toString());

        return "/members/post";
    }

    @GetMapping("post/{postId}")
    public String show(@PathVariable Long postId, Model model) {
        log.info("id = " + postId);

        Optional<PostEntity> postEntity = postRepository.findById(postId);
        model.addAttribute("postEntity", postEntity);
        return "post/show";
    }
}
