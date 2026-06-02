package com.example.javabackendtheoryspringboot.lesson29.homework;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("cars")
public class MyController {

    private ArrayList<Car> cars =  new ArrayList<>();

    @PostMapping("newCar")
    public String createNewCar(@RequestBody Car newCar){
        cars.add(newCar);
        return "Car created";
    }

    @GetMapping("")
    public ArrayList<Car> getCars(){
        return cars;
    }

    @GetMapping("{model}")
    public ArrayList<Car> getCarsByModel(@PathVariable String model){

    }
}
