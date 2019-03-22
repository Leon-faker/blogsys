package com.federik;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configuration
@ServletComponentScan
@EnableScheduling
@MapperScan("com.federik.mapper")
public class PersonalFederikApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalFederikApplication.class, args);
    }

}

