package com.app.itemservice.domain.item.repository;

import static com.app.itemservice.domain.item.QItem.item;

import com.app.itemservice.web.dto.item.ItemBrandDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ItemBrandRepository {

	private final JPAQueryFactory queryFactory;

	public ItemBrandRepository(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	public List<ItemBrandDto> findByBrandLowPrice() {
		return queryFactory
			.select(Projections.bean(ItemBrandDto.class,
				item.category,
				item.brand,
				item.price)
			)
			.from(item)
			.orderBy(item.brand.asc(), item.category.asc(), item.price.asc())
			.fetch();
	}
}
