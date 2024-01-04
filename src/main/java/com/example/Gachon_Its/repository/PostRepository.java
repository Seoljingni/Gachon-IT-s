package com.example.Gachon_Its.repository;

import com.example.Gachon_Its.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
