package com.leo.modules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author qingweiqu
 */
@EnableSwagger2
@SpringBootApplication
public class uniappApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(uniappApiApplication.class, args);
    }

}
