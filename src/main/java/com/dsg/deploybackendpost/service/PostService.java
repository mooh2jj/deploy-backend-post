package com.dsg.deploybackendpost.service;

import com.dsg.deploybackendpost.dto.PostDto;
import com.dsg.deploybackendpost.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostDto> getPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostDto::from)
                .toList();
    }

}
