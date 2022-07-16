package com.app.itemservice.web.dto.item.response;

import com.app.itemservice.web.dto.item.ItemCategoryDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseItemCategoryDto {

	private List<ItemCategoryDto> items = new ArrayList<>();

	public ResponseItemCategoryDto(ItemCategoryDto... itemCategoryDto) {
		items.addAll(Arrays.asList(itemCategoryDto));
	}
}
