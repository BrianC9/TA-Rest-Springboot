package me.bryanc.bkoolrestapi.repository;

import me.bryanc.bkoolrestapi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
