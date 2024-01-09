package com.example.Gachon_Its.repository;

import com.example.Gachon_Its.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
 
}

/*public interface PostRepository extends JpaRepository<PostEntity, Long> {

    // UserEntity의 userId를 기반으로 PostEntity 찾기
    List<PostEntity> findByUserEntityUserId(String userId);

}*/
