package com.dsg.deploybackendpost.entity;

import com.dsg.deploybackendpost.dto.PostRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "posts")
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;


    public static Post of(PostRequest request) {
        return Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public void update(PostRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
