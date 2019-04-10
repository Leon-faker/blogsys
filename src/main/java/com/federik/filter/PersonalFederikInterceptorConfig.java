package com.federik.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class PersonalFederikInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    public PersonalFederkInterceptor personalFederkInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(personalFederkInterceptor).addPathPatterns("/**").excludePathPatterns("/federik/loginuser","/federik/invaliduser","/federik/checkLogin");
    }
}
