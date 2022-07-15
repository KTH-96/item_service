package com.app.itemservice.service;

import com.app.itemservice.domain.item.Category;
import com.app.itemservice.domain.item.repository.ItemAllRepository;
import com.app.itemservice.web.dto.item.ItemAllDto;
import com.app.itemservice.web.dto.item.ResponseItemAllDto;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ItemService {

	private final ItemAllRepository itemAllRepository;

	@Transactional(readOnly = true)
	public ResponseItemAllDto findAllLowPrice() {
		List<ItemAllDto> allByLowPrice = itemAllRepository.findAllByLowPrice()
			.stream().distinct()
			.collect(Collectors.toList());

		return new ResponseItemAllDto(allByLowPrice);
	}
}
