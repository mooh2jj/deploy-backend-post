package com.dsg.deploybackendpost.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties("cors")
public class CorsAllowedOriginsProps {

    private List<String> allowedOrigins;

}
