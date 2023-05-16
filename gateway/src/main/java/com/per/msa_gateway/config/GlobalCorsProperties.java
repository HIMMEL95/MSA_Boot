package com.per.msa_gateway.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

@ConfigurationProperties("spring.cloud.gateway.globalcors")
public class GlobalCorsProperties {
    private final Map<String, CorsConfiguration> corsConfigurations = new LinkedHashMap<>();

    public Map<String, CorsConfiguration> getCorsConfigurations() {
        return corsConfigurations;
    }
}
