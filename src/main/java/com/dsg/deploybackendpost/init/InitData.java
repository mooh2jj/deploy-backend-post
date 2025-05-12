package com.dsg.deploybackendpost.init;

import com.dsg.deploybackendpost.entity.Post;
import com.dsg.deploybackendpost.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Slf4j
@Configuration
//@Profile({"test", "dev"})    // test, dev 환경에서만 실행
@RequiredArgsConstructor
public class InitData {

    private final PostRepository postRepository;

    @Bean
    CommandLineRunner init() {
        return (args) -> {
            log.info("test data init run...");
            // Post 데이터 초기화
            // 만약 DB 조회시 데이터가 없으면 초기화
            if(postRepository.count() > 0) {
                return;
            }
            List<Post> posts = List.of(
                    new Post("제목1", "내용1"),
                    new Post("제목2", "내용2"),
                    new Post("제목3", "내용3"),
                    new Post("제목4", "내용4"),
                    new Post("제목5", "내용5")
            );
            // Post 데이터 저장
            postRepository.saveAll(posts);
        };
    }
}
