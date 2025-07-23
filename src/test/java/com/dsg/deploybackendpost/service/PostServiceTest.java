package com.dsg.deploybackendpost.service;

import com.dsg.deploybackendpost.dto.PostDto;
import com.dsg.deploybackendpost.dto.PostRequest;
import com.dsg.deploybackendpost.entity.Post;
import com.dsg.deploybackendpost.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    @DisplayName("모든 게시글을 조회하면 게시글 목록이 반환된다")
    void getPosts_ShouldReturnAllPosts() {

        // given
        LocalDateTime now = LocalDateTime.now();
        PostRequest request1 = PostRequest.of("제목1", "내용1");
        PostRequest request2 = PostRequest.of("제목2", "내용2");

        Post post1 = Post.of(request1);
        Post post2 = Post.of(request2);
        
        // BaseTimeEntity의 필드는 직접 설정할 수 없으므로 리플렉션을 사용하지 않고 테스트
        List<Post> posts = Arrays.asList(post1, post2);
        // when
        when(postRepository.findAll()).thenReturn(posts);
        List<PostDto> result = postService.getPosts();

        // then
        log.info("getPosts result: {}", result);

    }
} 