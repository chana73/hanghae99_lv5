package com.example.post_hanghae.repository;

import com.example.post_hanghae.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    @Query("select count (pl) from PostLike pl where pl.postId = :postId and pl.pLike = true and pl.username = :username")
    Long CntByPostIdAndUsername(@Param("postId") Long postId, @Param("username") String username);

    @Query("select pl from PostLike pl where pl.postId = :postId and pl.pLike = true and pl.username = :username")
    PostLike findByPostIdAndUsername(@Param("postId") Long postId, @Param("username") String username);

    @Query("select count (pl) from PostLike pl where pl.postId = :postId and pl.pLike = true")
    Long countPlike(@Param("postId") Long postId);

}
