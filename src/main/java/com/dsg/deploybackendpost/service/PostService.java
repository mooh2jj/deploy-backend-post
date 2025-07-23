package com.dsg.deploybackendpost.service;

import com.dsg.deploybackendpost.dto.PostDto;
import com.dsg.deploybackendpost.dto.PostRequest;
import com.dsg.deploybackendpost.entity.Post;
import com.dsg.deploybackendpost.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostDto> getPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostDto::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public PostDto getPost(Long id) {
        return postRepository.findById(id)
                .map(PostDto::from)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + id));
    }


    public Long createPost(PostRequest request) {
        return postRepository.save(Post.of(request))
                .getId();
    }

    public Long updatePost(Long id, PostRequest request) {
        Post post = getById(id);
        post.update(request);
        return post.getId();
    }


    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    private Post getById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + id));
    }


}
