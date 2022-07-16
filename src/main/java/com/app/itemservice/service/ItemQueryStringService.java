package com.app.itemservice.service;

import com.app.itemservice.domain.item.Item;
import com.app.itemservice.domain.item.repository.ItemRepository;
import com.app.itemservice.web.dto.item.request.RequestItemDto;
import com.app.itemservice.web.dto.item.response.ResponseItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ItemQueryStringService {

	private final ItemRepository itemRepository;

	@Transactional
	public ResponseItemDto add(RequestItemDto dto) {
		Item savedItem = itemRepository.save(dto.toEntity());
		return new ResponseItemDto(Item.toItemDto(savedItem));
	}

	@Transactional
	public ResponseItemDto update(Long id, RequestItemDto dto) {
		Item item = findItemByItemIdOrThrow(id);
		item.update(dto);
		return new ResponseItemDto(Item.toItemDto(item));
	}

	@Transactional
	public ResponseItemDto delete(Long id) {
		Item item = findItemByItemIdOrThrow(id);
		itemRepository.delete(item);
		return new ResponseItemDto(Item.toItemDto(item));
	}

	private Item findItemByItemIdOrThrow(Long id) {
		return itemRepository.findById(id)
			.orElseThrow(RuntimeException::new);
	}
}
