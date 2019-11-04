package com.leo.modules.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 配置
 *
 * @author qingweiqu
 */
@Data
@Component
@PropertySource("classpath:config.properties")
public class ConfigInfo {

    /**
     * 域名配置
     */
    @Value("${base.domain}")
    private String baseDomain;

    private String uploadRecordPath;



}
