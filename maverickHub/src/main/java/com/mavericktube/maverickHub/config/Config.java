package com.mavericktube.maverickHub.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
@Configuration
public class Config {
    @Value("${cloud.api.name}")
    private String cloudName;
    @Value("${cloud.api.secret}")
    private String cloudSecret;
    @Value("${cloud.api.key}")
    private String cloudKey;
    @Bean
    public Cloudinary cloudinary() {
        Map<?, ?> map = ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", cloudKey,
                "api_secret", cloudSecret
        );
        return new Cloudinary(map);
    }
}
