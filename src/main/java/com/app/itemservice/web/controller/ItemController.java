package com.app.itemservice.web.controller;

import com.app.itemservice.service.ItemService;
import com.app.itemservice.web.dto.item.ResponseItemAllDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
