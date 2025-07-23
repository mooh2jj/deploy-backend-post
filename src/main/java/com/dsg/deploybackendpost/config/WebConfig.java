package com.dsg.deploybackendpost.config;

import com.dsg.deploybackendpost.props.CorsAllowedOriginsProps;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final CorsAllowedOriginsProps props;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(props.getAllowedOrigins().toArray(new String[0])) // 프론트 허용 주소 설정
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                .maxAge(3600) // 1시간 동안 preflight 요청 결과를 캐시
                .allowCredentials(true);
    }
}

