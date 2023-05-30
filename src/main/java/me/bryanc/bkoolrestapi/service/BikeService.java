package me.bryanc.bkoolrestapi.service;

import me.bryanc.bkoolrestapi.model.Bike;
import me.bryanc.bkoolrestapi.repository.BikeRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Cacheable(value = "bikes")
    public List<Bike> getAll(){
        //if (bikeRepository.count() === 0) return ResponseEntity.noContent().build();
        return bikeRepository.findAll();
    }

    @CacheEvict(value = "bikes", allEntries = true)
    public Bike createBike(Bike newBike){
        if("".equals(newBike.getName().trim()) || newBike.getId() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Bike createdBike = bikeRepository.save(newBike);
        return createdBike;
    }

    @Cacheable(value = "bikes")
    public List<Bike> searchBikes(String bikeName, String bikeManufacturer, String bikeItemType, String sort){
        if (sort.equals("desc")) {
            return bikeRepository.searchBikesOrderByNameDesc(bikeName, bikeManufacturer, bikeItemType);
        }
        return bikeRepository.searchBikesOrderByNameAsc(bikeName,bikeManufacturer,bikeItemType);
    }

}
