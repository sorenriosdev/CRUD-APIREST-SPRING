package com.edu.cibertec.Crud_apiRest.service.impl;

import com.edu.cibertec.Crud_apiRest.dto.CarDto;
import com.edu.cibertec.Crud_apiRest.entity.Car;
import com.edu.cibertec.Crud_apiRest.repository.CarRepository;
import com.edu.cibertec.Crud_apiRest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarDto> listCars() {
        List<CarDto> carDtos = new ArrayList<>();
        Iterable<Car> cars = carRepository.findAll();
        cars.forEach(car -> {
            CarDto carDto = new CarDto(
                    car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getEngineType(),
                    car.getColor()
            );
            carDtos.add(carDto);
        });
        return carDtos;
    }

    @Override
    public CarDto detailCar(int id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            Car carEntity = car.get();
            return new CarDto(
                    carEntity.getCarId(),
                    carEntity.getMake(),
                    carEntity.getModel(),
                    carEntity.getYear(),
                    carEntity.getEngineType(),
                    carEntity.getColor()
            );
        }
        return null;
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = new Car();
        car.setMake(carDto.make());
        car.setModel(carDto.model());
        car.setYear(carDto.year());
        car.setEngineType(carDto.engineType());
        car.setColor(carDto.color());
        Car savedCar= carRepository.save(car);
        return new CarDto(
                savedCar.getCarId(),
                savedCar.getMake(),
                savedCar.getModel(),
                savedCar.getYear(),
                savedCar.getEngineType(),
                savedCar.getColor()
        );
    }

    @Override
    public CarDto updateCar(int id, CarDto carDto) {
        if(carRepository.existsById(id)) {
            Car car = new Car();
            car.setCarId(id); // Asegura que el ID se mantenga igual
            car.setMake(carDto.make());
            car.setModel(carDto.model());
            car.setYear(carDto.year());
            car.setEngineType(carDto.engineType());
            car.setColor(carDto.color());
            Car updatedCar = carRepository.save(car);
            return new CarDto(
                    updatedCar.getCarId(),
                    updatedCar.getMake(),
                    updatedCar.getModel(),
                    updatedCar.getYear(),
                    updatedCar.getEngineType(),
                    updatedCar.getColor()
            );
        }
        return null;
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
