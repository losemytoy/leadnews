package com.heima.apis.config;

import com.heima.apis.fallback.ArticleClientFallbackFactory;
import org.springframework.context.annotation.Bean;

public class DefaultFeignConfig {
    @Bean
    public ArticleClientFallbackFactory articleClientFallbackFactory() {
        return new ArticleClientFallbackFactory();
    }
}
