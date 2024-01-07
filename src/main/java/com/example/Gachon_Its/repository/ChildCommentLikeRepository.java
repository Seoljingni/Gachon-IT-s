package com.example.Gachon_Its.repository;

import com.example.Gachon_Its.entity.ChildCommentLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ChildCommentLikeRepository extends JpaRepository<ChildCommentLikeEntity, Long> {
}
