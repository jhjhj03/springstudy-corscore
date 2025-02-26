package com.example.web;

import com.example.cors.properties.CorsProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties(CorsProperties.class) //<-이번에만
//@ConfigurationPropertiesScan(basePackages = "com.example")
public class CorsConfig implements WebMvcConfigurer {

    private final CorsProperties corsProperties;

    public CorsConfig(CorsProperties corsProperties){
        this.corsProperties = corsProperties;
    }

    // Ctrl + i -> CORS Mapping 관련 함수

    @Override

    public void addCorsMappings(CorsRegistry registry) {
        var allowed = corsProperties.allowed();
        var exposed = corsProperties.exposed();
        var maxAge = corsProperties. maxAge();

        registry.addMapping("/**")
                .allowedHeaders("*") // *: asterisk, 기능적으로 "와일드 카드" 역할로 자주 사용됨
                .allowedMethods("*") //공통(Get,POST,PATCH,DELETE, HEAD,TRACE) + 확장된 메서드들
                .allowedOrigins(
                        "http://localhost:3000",
                        "https://localhost:3000"
                )
                .allowCredentials(true)
                .exposedHeaders("*")
                .maxAge(3600L);
    }
}