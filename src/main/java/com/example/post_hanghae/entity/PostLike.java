package com.example.post_hanghae.entity;

import com.example.post_hanghae.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private boolean pLike;


    // 게시물 좋아요
    public PostLike (Long postId, String username, boolean pLike) {
        this.postId = postId;
        this.username = username;
        this.pLike = pLike;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void update(boolean pLike) {
        this.pLike = pLike;
    }
}
