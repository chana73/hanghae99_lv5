package com.example.post_hanghae.controller;

import com.example.post_hanghae.dto.AllResponseDto;
import com.example.post_hanghae.dto.MsgResponseDto;
import com.example.post_hanghae.dto.PostRequestDto;
import com.example.post_hanghae.dto.PostResponseDto;
import com.example.post_hanghae.security.UserDetailsImpl;
import com.example.post_hanghae.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //JSON 형식으로 내리는 것
@RequiredArgsConstructor
@RequestMapping("/api") // URL에서 공통된 api 담아주는 것
public class PostController {

    private final PostService postService; // 외부에서 절대 건들이지 못하도록 private!

    // 게시글 작성
    @PostMapping("/post")
    public PostResponseDto creatPost(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.createPost(postRequestDto, userDetails.getUser());
    }

    //게시글 조회
    @GetMapping("/posts")
    public List<AllResponseDto> getPosts() {

        return postService.getPosts();
    }

    //게시글 선택조회
    @GetMapping("/get/{id}")
    public AllResponseDto getPost(@PathVariable Long id) {

        return postService.getPost(id);
    }

    //게시글 수정
    @PutMapping("/put/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.update(id, postRequestDto, userDetails.getUser());
    }


    //게시글 삭제
    @DeleteMapping("/delete/{id}")
    public MsgResponseDto deleteAll(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.deleteAll(id, userDetails.getUser());
    }


    //게시글 좋아요
    @PostMapping("/post/{id}/like")
    public MsgResponseDto creatPostLike(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.savePostLike(id, userDetails.getUser());
    }
}