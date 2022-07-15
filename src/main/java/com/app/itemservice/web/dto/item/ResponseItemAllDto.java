package com.app.itemservice.web.dto.item;

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
}
