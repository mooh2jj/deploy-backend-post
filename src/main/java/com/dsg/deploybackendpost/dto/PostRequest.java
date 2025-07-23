package com.dsg.deploybackendpost.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {

    private String title;
    private String content;

    public static PostRequest of(String title, String content) {
        return PostRequest.builder()
                .title(title)
                .content(content)
                .build();
    }

}
