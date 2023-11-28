//package com.heima.wemedia.config;
//
//import com.heima.utils.common.OssUtil;
//import com.heima.utils.properties.OssProperties;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@Slf4j
//public class OssConfiguration {
//
//    @Bean
//    @ConditionalOnMissingBean
//    public OssUtil ossUtil(OssProperties ossProperties) {
//        return new OssUtil(ossProperties.getEndpoint(),
//                ossProperties.getAccessKeyId(),
//                ossProperties.getAccessKeySecret(),
//                ossProperties.getBucketName());
//    }
//}
