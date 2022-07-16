package com.app.itemservice.config;

import com.app.itemservice.config.converter.StringToCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 *	클라이언트가 대소문자 상관없이 category를 호출할 수 있게 해주는 컨버터
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToCategory());
	}

}
