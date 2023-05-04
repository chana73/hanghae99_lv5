package com.example.post_hanghae.repository;

import com.example.post_hanghae.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {

    @Query("select count (cl) from CommentLike cl where cl.commentId = :commentId and cl.cLike = true and cl.username = :username")
    Long CntByCommentIdAndUsername(@Param("commentId") Long commentId, @Param("username") String username);

    @Query("select cl from CommentLike cl where cl.commentId = :commentId and cl.cLike = true and cl.username = :username")
    CommentLike findByCommentIdAndUsername(@Param("commentId") Long commentId, @Param("username") String username);

    @Query("select count (cl) from CommentLike cl where cl.commentId = :commentId and cl.cLike = true")
    Long countClike(@Param("commentId") Long commentId);

}
