package com.web.store.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan({"com.web.store.controller","com.web.store.service.impl","com.web.store.dao.impl","com.web.store.config"})//要掃描的
public class WebAppConfig implements WebMvcConfigurer {

	
		@Bean //視圖解析器
		public ViewResolver viewResolver() {
			InternalResourceViewResolver resolver
			 								=  new InternalResourceViewResolver();
			resolver.setPrefix("/WEB-INF/views/");//前導字-前面一定要斜線開頭且斜線結束(加在邏輯名稱的前面)
			resolver.setSuffix(".jsp");//後置字(加在邏輯名稱的後面)
			return resolver;
		}
		
		@Bean //常屬外部化檔案
		public MessageSource messageSource() {
			ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
			rbms.setBasename("messages");
			return rbms;
			
		}	
		
		@Override //使用靜態資源
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
		     registry.addResourceHandler("/css/**")
		             .addResourceLocations("/WEB-INF/views/css/");
		     registry.addResourceHandler("/image/**")
		             .addResourceLocations("/WEB-INF/views/images/");
		} 
		
		@Bean
		public CommonsMultipartResolver multipartResolver() {
			CommonsMultipartResolver resolver = new CommonsMultipartResolver();
			resolver.setDefaultEncoding("UTF-8");
			resolver.setMaxUploadSize(81920000);
			return resolver;
		}
}
