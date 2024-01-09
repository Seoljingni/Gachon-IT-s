package com.example.Gachon_Its.repository;

import com.example.Gachon_Its.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByUserEntityUserId(String userId);
}
