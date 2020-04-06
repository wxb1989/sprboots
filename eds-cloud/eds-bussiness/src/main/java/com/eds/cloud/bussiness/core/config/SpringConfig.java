package com.eds.cloud.base.core.config;

import feign.RequestInterceptor;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * spring配置的bean都放在这里
 * @author wangxuebin
 *
   也可以用这种方式做跨域
  extends WebMvcConfigurationSupport
  @Override
protected void addCorsMappings(CorsRegistry registry) {
registry.addMapping("/**")
.allowCredentials(true)
.allowedHeaders("*")
.allowedOrigins("*")
.allowedMethods("*");
}
 */
@Configuration
public class SpringConfig   {

    @LoadBalanced
    @Bean
    RestTemplate loadBalanced() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    @Primary
    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }
    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }


    @Bean
    public RequestInterceptor headerInterceptor() {
        return requestTemplate -> {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            requestTemplate.header("Authorization", request.getHeader("Authorization"));
        };
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES)); //KB,MB
        /// 设置总上传数据总大小50M
        factory.setMaxRequestSize(DataSize.of(50, DataUnit.MEGABYTES));//KB,MB
        return factory.createMultipartConfig();
    }

    /**
     * 跨域配置
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        List<String> allowedHeaders = Arrays.asList("Content-Type","x-auth-token","accept","Origin","Access-Control-Request-Headers","Access-Control-Request-Method",  "X-Requested-With", "XMLHttpRequest");
        List<String> exposedHeaders = Arrays.asList("Content-Type","x-auth-token","accept","Origin","Access-Control-Request-Headers","Access-Control-Request-Method",  "X-Requested-With", "XMLHttpRequest");
        List<String> allowedMethods = Arrays.asList("POST", "GET", "DELETE", "PUT", "OPTIONS");
        List<String> allowedOrigins = Arrays.asList("*");

        config.setAllowedHeaders(allowedHeaders);
        config.setAllowedMethods(allowedMethods);
        config.setAllowedOrigins(allowedOrigins);
        config.setExposedHeaders(exposedHeaders);
        config.setMaxAge(36000L);
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(configSource);
    }
}
