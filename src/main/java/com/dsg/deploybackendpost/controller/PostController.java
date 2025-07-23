package com.dsg.deploybackendpost.controller;

import com.dsg.deploybackendpost.dto.PostDto;
import com.dsg.deploybackendpost.dto.PostRequest;
import com.dsg.deploybackendpost.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long id) {
        log.info("getPostById: {}", id);
        PostDto dto = postService.getPost(id);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createPost(@RequestBody PostRequest request) {
        log.info("createPost request: {}", request);
        Long postId = postService.createPost(request);
        return new ResponseEntity<>(postId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePost(@PathVariable Long id, @RequestBody PostRequest request) {
        log.info("updatePost id: {}, request: {}", id, request);
        Long postId = postService.updatePost(id, request);
        return new ResponseEntity<>(postId, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        log.info("deletePost id: {}", id);
        postService.deletePost(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }
}
