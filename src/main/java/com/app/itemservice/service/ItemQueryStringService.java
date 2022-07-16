package com.app.itemservice.service;

import com.app.itemservice.domain.item.Item;
import com.app.itemservice.domain.item.repository.ItemRepository;
import com.app.itemservice.web.dto.item.request.RequestItemAddDto;
import com.app.itemservice.web.dto.item.response.ResponseItemAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ItemQueryStringService {

	private final ItemRepository itemRepository;

	@Transactional
	public ResponseItemAddDto add(RequestItemAddDto dto) {
		Item savedItem = itemRepository.save(dto.toEntity());
		return new ResponseItemAddDto(Item.toItemDto(savedItem));
	}


}
