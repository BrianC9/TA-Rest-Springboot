package me.bryanc.bkoolrestapi.controller;

import me.bryanc.bkoolrestapi.model.Bike;
import me.bryanc.bkoolrestapi.repository.BikeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {

    private final BikeRepository bikeRepository;

    public BikeController(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @GetMapping()

    public List<Bike> findAll(){
        return bikeRepository.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Bike createBike(@RequestBody Bike newBike){
        if("".equals(newBike.getName().trim())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Bike name is mandatory");
        }
        return bikeRepository.save(newBike);
    }
}
