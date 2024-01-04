package com.example.Gachon_Its.repository;

import com.example.Gachon_Its.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

}
