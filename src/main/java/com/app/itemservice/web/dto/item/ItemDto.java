package com.app.itemservice.web.dto.item;

import com.app.itemservice.domain.item.Brand;
import com.app.itemservice.domain.item.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

	private Category category;

	private Brand brand;

	private int price;
}
