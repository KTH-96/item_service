package com.app.itemservice.domain.item.repository;

import static com.app.itemservice.domain.item.QItem.item;

import com.app.itemservice.domain.item.QItem;
import com.app.itemservice.web.dto.item.ItemAllDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ItemAllRepository {

	private final JPAQueryFactory queryFactory;

	public ItemAllRepository(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	public List<ItemAllDto> findAllByLowPrice() {
		QItem subItem = new QItem("subItem");
		return queryFactory
			.select(Projections.bean(ItemAllDto.class,
				item.category,
				item.brand,
				item.price)
				)
			.from(item)
			.where(
				item.price.eq(
					JPAExpressions.select(subItem.price.min())
						.from(subItem)
						.where(
							subItem.category.eq(item.category)
						)
				)
			)
			.distinct()
			.orderBy(item.brand.asc())
			.fetch();
	}

}
