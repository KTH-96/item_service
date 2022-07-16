package com.app.itemservice.domain.item;

import com.app.itemservice.web.dto.item.ItemDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long id;

	@Enumerated(EnumType.STRING)
	private Brand brand;

	@Enumerated(EnumType.STRING)
	private Category category;

	private int price;

	@Builder
	public Item(Category category, Brand brand, int price) {
		this.category = category;
		this.brand = brand;
		this.price = price;
	}

	public static ItemDto toItemDto(Item item){
		return new ItemDto(
			item.category,
			item.brand,
			item.price
		);
	}
}
