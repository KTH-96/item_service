package com.app.itemservice.web.dto.item.response;

import com.app.itemservice.domain.item.Item;
import com.app.itemservice.web.dto.item.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseItemAddDto {

	private ItemDto savedItem;

}
