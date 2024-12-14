package com.edu.cibertec.Crud_apiRest.service;

import com.edu.cibertec.Crud_apiRest.dto.CarDto;
import com.edu.cibertec.Crud_apiRest.entity.Car;

import java.util.List;

public interface CarService {
    List<CarDto> listCars();
    CarDto detailCar(int id);
    CarDto createCar(CarDto carDto);
    CarDto updateCar(int id, CarDto carDto);
    void deleteCar(int id);
}
