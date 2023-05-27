package me.bryanc.bkoolrestapi.repository;

import me.bryanc.bkoolrestapi.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {
}
