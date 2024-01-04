package com.example.Gachon_Its.repository;

import com.example.Gachon_Its.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
