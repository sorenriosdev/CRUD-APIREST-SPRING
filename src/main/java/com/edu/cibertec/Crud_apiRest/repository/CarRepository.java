package com.edu.cibertec.Crud_apiRest.repository;

import com.edu.cibertec.Crud_apiRest.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
