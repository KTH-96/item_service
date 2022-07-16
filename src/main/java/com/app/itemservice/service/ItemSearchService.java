package com.app.itemservice.service;

import com.app.itemservice.domain.item.Brand;
import com.app.itemservice.domain.item.Category;
import com.app.itemservice.domain.item.repository.ItemAllRepository;
import com.app.itemservice.domain.item.repository.ItemBrandRepository;
import com.app.itemservice.domain.item.repository.ItemCategoryRepository;
import com.app.itemservice.web.dto.item.ItemAllDto;
import com.app.itemservice.web.dto.item.ItemBrandDto;
import com.app.itemservice.web.dto.item.ItemCategoryDto;
import com.app.itemservice.web.dto.item.response.ResponseItemAllDto;
import com.app.itemservice.web.dto.item.response.ResponseItemBrandDto;
import com.app.itemservice.web.dto.item.response.ResponseItemCategoryDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder.In;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ItemSearchService {

	private final ItemAllRepository itemAllRepository;

	private final ItemBrandRepository itemBrandRepository;

	private final ItemCategoryRepository itemCategoryRepository;

	@Transactional(readOnly = true)
	public ResponseItemAllDto findAllLowPrice() {
		List<ItemAllDto> allByLowPrice = itemAllRepository.findAllByLowPrice()
			.stream().distinct()
			.collect(Collectors.toList());

		return new ResponseItemAllDto(allByLowPrice);
	}

	@Transactional(readOnly = true)
	public ResponseItemBrandDto findBrandLowPrice() {
		Map<Brand, Integer> map = itemBrandRepository.findByBrandLowPrice().stream()
			.distinct()
			.collect(Collectors.groupingBy(ItemBrandDto::getBrand, Collectors.summingInt(ItemBrandDto::getPrice)));

		Comparator<Entry<Brand, Integer>> comparator = Entry.comparingByValue();

		Entry<Brand, Integer> min = Collections.min(map.entrySet(), comparator);

		return new ResponseItemBrandDto(min.getKey(), min.getValue());
	}

	@Transactional(readOnly = true)
	public ResponseItemCategoryDto findCategoryLowAndHighPrice(Category category) {
		return new ResponseItemCategoryDto(itemCategoryRepository.findByCategoryLowAndHighPrice(category));
	}
}
