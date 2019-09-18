package com.leo.modules.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * <p>
 * AppBaseConfiguration
 * </p>
 *
 * @author jackcooperz
 * @date 2019/8/8 19:01
 */
@Configuration
public class AppBaseConfiguration {


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    //@Bean
    //public HttpClientConnectionManager poolingConnectionManager() {
    //    PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager();
    //    // 连接池最大连接数
    //    poolingConnectionManager.setMaxTotal(1000);
    //    // 每个主机的并发
    //    poolingConnectionManager.setDefaultMaxPerRoute(100);
    //    return poolingConnectionManager;
    //}
    //
    //@Bean
    //public HttpClientBuilder httpClientBuilder() {
    //    HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
    //    //设置HTTP连接管理器
    //    httpClientBuilder.setConnectionManager(poolingConnectionManager());
    //    return httpClientBuilder;
    //}

    //@Bean
    //public ClientHttpRequestFactory clientHttpRequestFactory() {
    //    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
    //    clientHttpRequestFactory.setConnectTimeout(5 * 1000);
    //    clientHttpRequestFactory.setReadTimeout(30 * 1000);
    //    return clientHttpRequestFactory;
    //}

    //@Bean
    //public RestTemplate restTemplate() {
    //    RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
    //    Iterator<HttpMessageConverter<?>> iterator = restTemplate.getMessageConverters().iterator();
    //    while (iterator.hasNext()) {
    //        HttpMessageConverter converter = iterator.next();
    //        if (converter instanceof StringHttpMessageConverter) {
    //            StringHttpMessageConverter stringHttpMessageConverter = (StringHttpMessageConverter) converter;
    //            stringHttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));
    //            break;
    //        }
    //    }
    //    return restTemplate;
    //}

    @Bean
    public WebConfig webConfig() {
        return new WebConfig();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1
        corsConfiguration.addAllowedHeader("*"); // 2
        corsConfiguration.addAllowedMethod("*"); // 3
        return corsConfiguration;
    }
}
