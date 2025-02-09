package com.example.cors.properties;

import com.example.cors.properties.allowed.CorsAllowedProperties;
import com.example.cors.properties.exposed.CorsExposedProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("demo.webmvc.cors") //빈 등록
@ConfigurationPropertiesBinding
public record CorsProperties(
       @NestedConfigurationProperty CorsAllowedProperties allowed,
       @NestedConfigurationProperty CorsExposedProperties exposed,
        Long maxAge
) {
}
