package com.dsg.deploybackendpost.service;

import com.dsg.deploybackendpost.dto.PostDto;
import com.dsg.deploybackendpost.entity.Post;
import com.dsg.deploybackendpost.repository.PostRepository;
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
        Post post1 = new Post(1L, "제목1", "내용1");
        Post post2 = new Post(2L, "제목2", "내용2");
        
        // BaseTimeEntity의 필드는 직접 설정할 수 없으므로 리플렉션을 사용하지 않고 테스트
        List<Post> posts = Arrays.asList(post1, post2);
        // when
        when(postRepository.findAll()).thenReturn(posts);
        List<PostDto> result = postService.getPosts();

        // then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getId()).isEqualTo(1L);
        assertThat(result.get(0).getTitle()).isEqualTo("제목1");
        assertThat(result.get(0).getContent()).isEqualTo("내용1");
        assertThat(result.get(1).getId()).isEqualTo(2L);
        assertThat(result.get(1).getTitle()).isEqualTo("제목2");
        assertThat(result.get(1).getContent()).isEqualTo("내용2");

        // 메서드 호출 횟수 검증
        verify(postRepository, times(1)).findAll();
    }
} 