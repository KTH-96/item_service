package com.app.itemservice.web.controller;

import com.app.itemservice.domain.item.Category;
import com.app.itemservice.service.ItemService;
import com.app.itemservice.web.dto.item.ResponseItemAllDto;
import com.app.itemservice.web.dto.item.ResponseItemBrandDto;
import com.app.itemservice.web.dto.item.ResponseItemCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/item")
@RestController
public class ItemController {

	private final ItemService itemService;

	@GetMapping("/low_price/all")
	public ResponseItemAllDto all() {
		return itemService.findAllLowPrice();
	}

	@GetMapping("/low_price/brand")
	public ResponseItemBrandDto brand() {
		return itemService.findBrandLowPrice();
	}

	@GetMapping
	public ResponseItemCategoryDto category(@RequestParam("category") Category category) {
		return itemService.findCategoryLowAndHighPrice(category);
	}
}
