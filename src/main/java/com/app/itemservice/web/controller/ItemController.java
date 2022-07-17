package com.app.itemservice.web.controller;

import com.app.itemservice.domain.item.Category;
import com.app.itemservice.service.ItemQueryStringService;
import com.app.itemservice.service.ItemSearchService;
import com.app.itemservice.web.dto.item.request.RequestItemDto;
import com.app.itemservice.web.dto.item.response.ResponseItemAllDto;
import com.app.itemservice.web.dto.item.response.ResponseItemBrandDto;
import com.app.itemservice.web.dto.item.response.ResponseItemCategoryDto;
import com.app.itemservice.web.dto.item.response.ResponseItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/item")
@RestController
public class ItemController {

	private final ItemSearchService itemSearchService;

	private final ItemQueryStringService itemQueryStringService;

	@GetMapping("/low_price/all")
	public ResponseItemAllDto all() {
		log.debug("모든 카테고리의 상품을 브랜드 상관없이 구매할때 상품 최저값들 + 총합 조회");
		return itemSearchService.findAllLowPrice();
	}

	@GetMapping("/low_price/brand")
	public ResponseItemBrandDto brand() {
		log.debug("한 브랜드에서 모든 카테고리 상품을 구매시 브랜드 + 최저가 총합 조회");
		return itemSearchService.findBrandLowPrice();
	}

	@GetMapping
	public ResponseItemCategoryDto category(@RequestParam("category") Category category) {
		log.debug("{}에서 최소, 최대 가격 조회", category);
		return itemSearchService.findCategoryLowAndHighPrice(category);
	}

	@PostMapping
	public ResponseItemDto add(@RequestBody RequestItemDto dto) {
		log.debug("상품 추가");
		return itemQueryStringService.add(dto);
	}

	@PostMapping("/{id}")
	public ResponseItemDto update(@PathVariable Long id, @RequestBody RequestItemDto dto) {
		log.debug("상품 업데이트");
		return itemQueryStringService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public ResponseItemDto delete(@PathVariable Long id) {
		log.debug("상품 삭제");
		return itemQueryStringService.delete(id);
	}
}
