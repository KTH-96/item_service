package com.app.itemservice.web.dto.item;

import com.app.itemservice.domain.item.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemBrandDto {

	private Brand brand;

	private int totalPrice;

}
