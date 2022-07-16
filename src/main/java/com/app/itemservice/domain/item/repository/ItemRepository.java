package com.app.itemservice.domain.item.repository;

import com.app.itemservice.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
