package me.bryanc.bkoolrestapi.config;

import me.bryanc.bkoolrestapi.model.Bike;
import me.bryanc.bkoolrestapi.model.Item;
import me.bryanc.bkoolrestapi.repository.BikeRepository;
import me.bryanc.bkoolrestapi.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final  BikeRepository bikeRepository;
    private final ItemRepository itemRepository;

    public DataLoader(BikeRepository bikeRepository, ItemRepository itemRepository) {
        this.bikeRepository = bikeRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Item item1 = new Item(null, "ABC123", "Pedal", "A high-quality electronic device");
        Item item2 = new Item(null, "XYZ456", "Sillin", "A stylish decorative item for your home");
        Item item3 = new Item(null, "123DEF", "Ruedas", "A sports equipment for outdoor activities");
        itemRepository.saveAll(List.of(item1,item2,item3));

        Bike bike1 = new Bike(null, "Mountain Bike", "A rugged bike for off-road adventures", 599.99, "Trek", Set.of(item2,item3));
        Bike bike2 = new Bike(null, "Road Bike", "A lightweight bike for speed on paved roads", 1299.99, "Specialized",Set.of(item1,item2,item3));
        Bike bike3 = new Bike(null, "City Bike", "A comfortable bike for urban commuting", 499.99, "Giant",Set.of(item3));
        bikeRepository.saveAll(List.of(bike1,bike2,bike3));



    }
}
