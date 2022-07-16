package com.app.itemservice.web.dto.item;

import com.app.itemservice.domain.item.Brand;
import com.app.itemservice.domain.item.Category;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "price")
public class ItemBrandDto {

	private Category category;

	private Brand brand;

	private int price;

}
