package com.dsg.deploybackendpost.controller;

import com.dsg.deploybackendpost.dto.PostDto;
import com.dsg.deploybackendpost.entity.Post;
import com.dsg.deploybackendpost.repository.PostRepository;
import com.dsg.deploybackendpost.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }
}
