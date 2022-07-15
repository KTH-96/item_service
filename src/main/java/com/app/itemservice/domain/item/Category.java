package com.app.itemservice.domain.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

	TOP("TOP"),
	PANTS("PANTS"),
	OUTER("OUTER"),
	SNEAKERS("SNEAKERS"),
	BAG("BAG"),
	HAT("HAT"),
	SOCKS("SOCKS"),
	ACCESSORY("ACCESSORY");

	private final String value;
}
