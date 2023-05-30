package me.bryanc.bkoolrestapi.repository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import me.bryanc.bkoolrestapi.model.Bike;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BikeRepositoryTest {

    @Autowired
    private BikeRepository bikeRepository;

    @Test
    void saveBike() {
        Bike newBike = new Bike(null,"New Bike","A new bike created for testing",300.99,"Trek",null);
        Bike bikeSaved = bikeRepository.save(newBike);
        System.out.println(bikeSaved.getId());
        assertThat(bikeSaved.getId()).isNotNull();
    }
}
