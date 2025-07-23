package com.dsg.deploybackendpost.init;

import com.dsg.deploybackendpost.dto.PostRequest;
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
                    Post.of(PostRequest.of("SpringBoot 스터디", "Spring Boot 프레임워크의 핵심 기능을 배우는 스터디입니다. 파일업로드, JPA, Junit5 개발 등 실무에서 필요한 기술을 중점적으로 다룹니다.")),
                    Post.of(PostRequest.of("AWS 인프라&배포 스터디", "AWS 클라우드 환경에서의 인프라 구축과 애플리케이션 배포에 관한 스터디입니다. EC2, S3, Cloudfront, Route53, RDS 등의 서비스를 학습하고 CI/CD 파이프라인 구축 방법을 실습합니다. 클라우드 아키텍처 설계부터 실제 배포까지 전 과정을 경험할 수 있습니다.")),
                    Post.of(PostRequest.of("AI Python 업무자동화 스터디", "Python을 활용한 업무 자동화 및 AI 기반 자동화 솔루션 개발에 대한 스터디입니다. 데이터 수집, 전처리, 분석 자동화 및 머신러닝 모델 적용 방법을 배웁니다. Pandas, Numpy, Scikit-learn 등의 라이브러리를 활용해 실무에서 바로 적용 가능한 자동화 스크립트를 만들어봅니다.")),
                    Post.of(PostRequest.of("AI 웹앱 수익화 스터디", "AI 기술을 활용한 웹 애플리케이션 개발 및 수익화 전략에 관한 스터디입니다. 최신 AI API 통합, 서비스 모델 설계, 가격 책정 전략 등을 논의합니다. 참가자들은 각자의 AI 웹앱 아이디어를 발전시키고 실제 MVP를 구현하여 수익 창출 방안을 모색합니다.")),
                    Post.of(PostRequest.of("CS 스터디", "컴퓨터 과학의 기초 이론과 핵심 개념을 학습하는 스터디입니다. 자료구조, 알고리즘, 운영체제, 네트워크, 데이터베이스 등 개발자라면 알아야 할 CS 지식을 깊이 있게 다룹니다. 매주 한 명씩 주제를 맡아 발표하고 함께 토론하는 방식으로 진행됩니다."))
            );
            // Post 데이터 저장
            postRepository.saveAll(posts);
        };
    }
}
