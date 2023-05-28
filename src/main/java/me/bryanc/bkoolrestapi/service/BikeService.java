package me.bryanc.bkoolrestapi.service;

import me.bryanc.bkoolrestapi.model.Bike;
import me.bryanc.bkoolrestapi.repository.BikeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public ResponseEntity<List<Bike>> getAll(){
        //if (bikeRepository.count() === 0) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikeRepository.findAll());
    }

    public ResponseEntity<Bike> createBike(Bike newBike){
        if("".equals(newBike.getName().trim()) || newBike.getId() != null){
            return ResponseEntity.badRequest().build();
        }
        Bike createdBike = bikeRepository.save(newBike);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBike);
    }

    public ResponseEntity<List<Bike>> searchBikes(String bikeName, String bikeManufacturer, String bikeItemType, String sort){
        if (sort.equals("desc")) {
            return ResponseEntity.ok(bikeRepository.searchBikesOrderByNameDesc(bikeName, bikeManufacturer, bikeItemType));
        }
        return ResponseEntity.ok(bikeRepository.searchBikesOrderByNameAsc(bikeName,bikeManufacturer,bikeItemType));
    }

}
