package com.car;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
@MapperScan(basePackages = {"com.car.modules.*.dao"})
public class AdminApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication application=new SpringApplication(AdminApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    //
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminApplication.class);
    }
}
