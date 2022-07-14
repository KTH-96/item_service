package com.app.itemservice.domain.item;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Category {

	TOP("TOP", "상의"),
	PANTS("PANTS", "하의"),
	OUTER("OUTER", "아우터"),
	SNEAKERS("SNEAKERS", "스니커즈"),
	BAG("BAG", "가방"),
	HAT("HAT", "모자"),
	SOCKS("SOCKS", "양말"),
	ACCESSORY("ACCESSORY", "액세서리");

	private final String key;

	private final String value;
}
