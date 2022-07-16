package com.app.itemservice.service;

import com.app.itemservice.domain.item.repository.ItemAllRepository;
import com.app.itemservice.domain.item.repository.ItemBrandRepository;
import com.app.itemservice.web.dto.item.ItemAllDto;
import com.app.itemservice.web.dto.item.ItemBrandDto;
import com.app.itemservice.web.dto.item.ResponseItemAllDto;
import com.app.itemservice.web.dto.item.ResponseItemBrandDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ItemService {

	private final ItemAllRepository itemAllRepository;

	private final ItemBrandRepository itemBrandRepository;

	@Transactional(readOnly = true)
	public ResponseItemAllDto findAllLowPrice() {
		List<ItemAllDto> allByLowPrice = itemAllRepository.findAllByLowPrice()
			.stream().distinct()
			.collect(Collectors.toList());

		return new ResponseItemAllDto(allByLowPrice);
	}

	@Transactional(readOnly = true)
	public ResponseItemBrandDto findBrandLowPrice() {
		ItemBrandDto brandLowPrice = itemBrandRepository.findByBrandLowPrice();
		return new ResponseItemBrandDto(brandLowPrice.getBrand(), brandLowPrice.getTotalPrice());
	}
}
