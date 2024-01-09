package com.example.Gachon_Its.repository;

import com.example.Gachon_Its.entity.CommentLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CommentLikeRepository extends JpaRepository<CommentLikeEntity, Long> {
}
