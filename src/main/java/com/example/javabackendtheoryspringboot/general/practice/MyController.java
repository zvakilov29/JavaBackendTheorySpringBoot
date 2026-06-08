package com.example.javabackendtheoryspringboot.general.practice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping() // localhost:8080/api/car
public class MyController {

    private final List<Car> cars = new ArrayList<>();
    private Long nextId = 1L;

    @PostMapping//create
    @ResponseStatus(HttpStatus.CREATED)
    public Car createNewCar(@RequestBody Car newCar) {
        newCar.setId(nextId++);
        cars.add(newCar);
        return newCar;
    }

    @GetMapping
    public List<Car> getCars() {
        return cars;
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }
}
