package com.app.itemservice.web.dto.item.response;

import com.app.itemservice.web.dto.item.ItemAllDto;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseItemAllDto {

	private List<ItemAllDto> items = new ArrayList<>();

	private int totalPrice;

	public ResponseItemAllDto(List<ItemAllDto> items) {
		this.items = items;
		this.totalPrice = items.stream().mapToInt(ItemAllDto::getPrice).sum();
	}
}
