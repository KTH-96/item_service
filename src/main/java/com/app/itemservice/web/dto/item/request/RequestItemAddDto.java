package com.app.itemservice.web.dto.item.request;

import com.app.itemservice.domain.item.Brand;
import com.app.itemservice.domain.item.Category;
import com.app.itemservice.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestItemAddDto {

	private Category category;

	private Brand brand;

	private int price;

	public Item toEntity() {
		return Item.builder()
			.category(category)
			.brand(brand)
			.price(price)
			.build();
	}
}
