package com.example.Gachon_Its.repository;

import com.example.Gachon_Its.entity.PostLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PostLikeRepository extends JpaRepository<PostLikeEntity, Long> {
}
