package com.app.itemservice.web.dto.item;

import com.app.itemservice.domain.item.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseItemBrandDto {

	private Brand brand;

	private int totalPrice;

}
