package com.leo.modules.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 调度中心配置
 *
 * @author jackcooperz
 */
@Configuration
@PropertySource("classpath:config.properties")
@Data
public class DispatchCenterConfig {

    /**
     * 查重相关
     */

    @Value("${base.check.notify.url}")
    private String checkNotifyUrl;


    @Value("${base.app.name}")
    private String appName;

    /**
     * 调度中心api地址
     */
    @Value("${api.url}")
    private String apiUrl;

    /**
     * 调度中心中文查重 api key
     */
    @Value("${api.key}")
    private String apiKey;

    /**
     * 字数解析 api 地址
     */
    @Value("${api.url.task.parse}")
    private String taskParseUrl;

    /**
     * 报告删除 api 地址
     */
    @Value("${api.url.delreport}")
    private String delReportUrl;

    /**
     * 获取OSS上传信息
     */
    @Value("${api.url.policy}")
    private String policyUrl;

    /**
     * 提交查重 api 地址
     */
    @Value("${api.url.task.v2}")
    private String taskV2Url;

    /**
     * 查重状态获取 api 地址
     */
    @Value("${api.url.task.query}")
    private String taskQueryUrl;

    /**
     * 查重状态获取 api 地址
     */
    @Value("${api.url.task.verify}")
    private String taskVerifyUrl;

    /**
     * 查重状态获取 api 地址
     */
    @Value("${api.url.task.callback}")
    private String taskCallbackUrl;

    /**
     * 查重结果查看地址
     */
    @Value("${check.report.html.url}")
    private String reportHtmlUrl;

    /**
     * 查重结果下载地址
     */
    @Value("${check.report.zip.url}")
    private String reportZipUrl;



    /**
     * 降重配置
     */
    /**
     * 签名key
     */
    @Value("${reduce.sign}")
    private String reduceSign;
    /**
     * 提交降重地址
     */
    @Value("${reduce.url.submit}")
    private String reduceSubmitUrl;
    /**
     * 降重状态获取地址
     */
    @Value("${reduce.url.state}")
    private String reduceStateUrl;
    /**
     * 降重报告查看地址
     */
    @Value("${reduce.url.report}")
    private String reduceReportUrl;

}
