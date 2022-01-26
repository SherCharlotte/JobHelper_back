package com.jobHelper.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/register").setViewName("register");
		registry.addViewController("/pages/data").setViewName("pages/data");
		registry.addViewController("/pages/dataSearch").setViewName("pages/dataSearch");
		registry.addViewController("/pages/dataManage").setViewName("pages/dataManage");
		registry.addViewController("/pages/dataCloudPhoto").setViewName("pages/dataCloudPhoto");
	}
}
