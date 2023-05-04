package com.example.post_hanghae.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long commentId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private boolean cLike;

    public CommentLike (Long commentId, String username, boolean cLike) {
        this.commentId = commentId;
        this.username = username;
        this.cLike = cLike;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void update(boolean cLike) { this.cLike = cLike;}


}
