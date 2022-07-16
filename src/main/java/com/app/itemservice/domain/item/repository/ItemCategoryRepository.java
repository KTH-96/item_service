package com.app.itemservice.domain.item.repository;

import static com.app.itemservice.domain.item.QItem.*;

import com.app.itemservice.domain.item.Category;
import com.app.itemservice.domain.item.QItem;
import com.app.itemservice.web.dto.item.ItemCategoryDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ItemCategoryRepository {

	private final JPAQueryFactory queryFactory;

	private QItem subItem = new QItem("subItem");

	public ItemCategoryRepository(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	public ItemCategoryDto findByCategoryLowPrice(Category category) {
		return queryFactory
			.select(Projections.bean(ItemCategoryDto.class,
				item.brand,
				item.price)
				)
			.from(item)
			.where(
				item.category.eq(category),
				item.price.eq(
					JPAExpressions.select(subItem.price.min())
						.from(subItem)
						.where(
							subItem.category.eq(item.category)
						)
				)
			)
			.distinct()
			.fetchOne();
	}

	public ItemCategoryDto findByCategoryHighPrice(Category category) {
		return queryFactory
			.select(Projections.bean(ItemCategoryDto.class,
				item.brand,
				item.price)
			)
			.from(item)
			.where(
				item.category.eq(category),
				item.price.eq(
					JPAExpressions.select(subItem.price.max())
						.from(subItem)
						.where(
							subItem.category.eq(item.category)
						)
				)
			)
			.distinct()
			.fetchOne();
	}
}
