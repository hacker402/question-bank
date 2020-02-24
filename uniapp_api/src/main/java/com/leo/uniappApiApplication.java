package com.leo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author qingweiqu
 */

@SpringBootApplication(scanBasePackages = "com.leo")
public class uniappApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(uniappApiApplication.class, args);
    }

}
