package me.bryanc.bkoolrestapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "bikes")
public class Bike {
    @Id
    private Long id;

    private String name;
    @Nullable
    private String description;
    @Nullable
    private Double price;
    @Nullable
    private String manufacturer;

    public Bike() {
    }

    public Bike(Long id, String name, @Nullable String description, @Nullable Double price, @Nullable String manufacturer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @Nullable
    public Double getPrice() {
        return price;
    }

    public void setPrice(@Nullable Double price) {
        this.price = price;
    }

    @Nullable
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(@Nullable String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
