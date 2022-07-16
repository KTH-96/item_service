package com.app.itemservice.config.converter;

import com.app.itemservice.domain.item.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCategory implements Converter<String, Category> {

	@Override
	public Category convert(String value) {
		return Category.valueOf(value.toUpperCase());
	}
}
