package com.leo;

import com.github.xiaoymin.knife4j.spring.annotations.EnableSwaggerBootstrapUi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author qingweiqu
 */

@SpringBootApplication(scanBasePackages = "com.leo")
public class uniappApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(uniappApiApplication.class, args);
    }

}
