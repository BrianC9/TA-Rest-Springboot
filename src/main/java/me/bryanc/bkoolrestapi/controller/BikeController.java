package me.bryanc.bkoolrestapi.controller;

import me.bryanc.bkoolrestapi.model.Bike;
import me.bryanc.bkoolrestapi.service.BikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {

    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping()
    public ResponseEntity<List<Bike>> findAll(){
        return ResponseEntity.ok(bikeService.getAll());
    }

    /*
     *  Para añadir los items a una bike -> Endpoint LH:PORT/api/bikes/{id}/items
     *  @RequestBody HashMap<String, ArrayList<Integer>> items
     * {
     *  "items": [1,3,4]
     * }
     * @ResponseEntity.badRequest().build() en caso de que el id no corresponda a un item existente.
     *  */
    @PostMapping()
    public ResponseEntity<Bike> createBike(@RequestBody Bike newBike){
        return ResponseEntity.status(HttpStatus.CREATED).body(bikeService.createBike(newBike));
    }



    @GetMapping("/search")
    public ResponseEntity<List<Bike>> searchBy(@RequestParam(name = "name", defaultValue = "", required = false)String name,
                                               @RequestParam(name = "manufacturer", defaultValue = "",required = false)String manufacturer,
                                               @RequestParam(name="itemType",  defaultValue = "",required = false) String itemType,
                                               @RequestParam(required = false,defaultValue = "desc", name = "sort") String sort){

        System.out.printf("Values from RequestParams \n Name: %s, Manufacturer: %s, Item-Type: %s, Sort: %s ",name,manufacturer,itemType,sort);
        return ResponseEntity.ok(bikeService.searchBikes(name,manufacturer,itemType,sort));
    }


    }
