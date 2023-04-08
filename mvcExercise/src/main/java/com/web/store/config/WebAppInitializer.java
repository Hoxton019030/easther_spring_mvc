package com.web.store.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override //多模組大家要共用的(資料庫)
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{RootAppConfig.class};

	}

	@Override //單一的bean
	protected Class<?>[] getServletConfigClasses() {
		return  new Class[]{WebAppConfig.class};
	}

	@Override//那些請求要送到DISPATCHER
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		return new Filter[] {characterEncodingFilter};
	}

}
