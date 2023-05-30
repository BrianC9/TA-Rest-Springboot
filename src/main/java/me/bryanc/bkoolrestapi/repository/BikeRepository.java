package me.bryanc.bkoolrestapi.repository;

import jakarta.annotation.PostConstruct;
import me.bryanc.bkoolrestapi.model.Bike;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike, Long> {

    @Query(value =
    """
     select distinct b.*
     from bike b
     left join  "bike_item" "bi" on b.id = "bi".fk_bike
     left join item i on bi.fk_item = i.id
     where b.name ILIKE %:name% and b.manufacturer ILIKE %:manufacturer% and (i.type ilike %:itemType% or i.type is null)
     ORDER BY b.name asc
    """, nativeQuery = true)
    List<Bike> searchBikesOrderByNameAsc(@Param("name") String name, @Param("manufacturer") String manufacturer,@Param("itemType") String itemType);

    @Query(value =
            """
           select distinct b.*
           from bike b
           left join  "bike_item" "bi" on b.id = "bi".fk_bike
           left join item i on bi.fk_item = i.id
           where b.name ILIKE %:name% and b.manufacturer ILIKE %:manufacturer% and (i.type ilike %:itemType% or i.type is null)
           ORDER BY b.name desc
            """, nativeQuery = true)
    List<Bike> searchBikesOrderByNameDesc(@Param("name") String name, @Param("manufacturer") String manufacturer,@Param("itemType") String itemType);
}
