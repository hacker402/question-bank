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

    /**
     *  第三方授权地址
     */
    @Value("${base.check.auth.url}")
    private String checkThirdAuthUrl;

    /**
     * 授权时间 365天
     */
    @Value("${taobao.site.auth.days}")
    private Integer authDays;

    /**
     * 应用名称：redis-key 分类
     */
    @Value("${base.app.name}")
    private String appName;

    /**
     * 查重/降重地址
     */
    @Value("${base.check.url}")
    private String checkUrl;

    /**
     * 阿里旺旺前缀
     */
    @Value("${taobao.alitalk.domain.prefix}")
    private String aLiTalkDomainPrefix;

    /**
     * QQ前缀
     */
    @Value("${taobao.qq.domain.prefix}")
    private String qqDomainPrefix;

    /**
     * 淘宝宝贝前缀
     */
    @Value("${taobao.site.goods.link.prefix}")
    private String siteGoodsLinkPrefix;

}
