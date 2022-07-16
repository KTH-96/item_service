package com.app.itemservice.web.controller;

import com.app.itemservice.domain.item.Category;
import com.app.itemservice.service.ItemQueryStringService;
import com.app.itemservice.service.ItemSearchService;
import com.app.itemservice.web.dto.item.request.RequestItemAddDto;
import com.app.itemservice.web.dto.item.response.ResponseItemAddDto;
import com.app.itemservice.web.dto.item.response.ResponseItemAllDto;
import com.app.itemservice.web.dto.item.response.ResponseItemBrandDto;
import com.app.itemservice.web.dto.item.response.ResponseItemCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/item")
@RestController
public class ItemController {

	private final ItemSearchService itemSearchService;

	private final ItemQueryStringService itemQueryStringService;

	@GetMapping("/low_price/all")
	public ResponseItemAllDto all() {
		return itemSearchService.findAllLowPrice();
	}

	@GetMapping("/low_price/brand")
	public ResponseItemBrandDto brand() {
		return itemSearchService.findBrandLowPrice();
	}

	@GetMapping
	public ResponseItemCategoryDto category(@RequestParam("category") Category category) {
		return itemSearchService.findCategoryLowAndHighPrice(category);
	}

	@PostMapping
	public ResponseItemAddDto add(@RequestBody RequestItemAddDto dto) {
		return itemQueryStringService.add(dto);
	}
}
