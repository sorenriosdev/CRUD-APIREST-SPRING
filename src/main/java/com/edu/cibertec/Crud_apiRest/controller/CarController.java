package com.edu.cibertec.Crud_apiRest.controller;

import com.edu.cibertec.Crud_apiRest.dto.CarDto;
import com.edu.cibertec.Crud_apiRest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CrudCar")
public class CarController {

    @Autowired
    private CarService carService;

    // Consultar todos los cars
    @GetMapping("/all")
    public List<CarDto> listCars() {
        return carService.listCars();
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<CarDto> detailCar(@PathVariable int id) {
        CarDto carDto = carService.detailCar(id);
        if(carDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto) {
        CarDto car = carService.createCar(carDto);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable int id, @RequestBody CarDto carDto) {
        CarDto updatedCar = carService.updateCar(id, carDto);
        if (updatedCar != null) {
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
    }
}
