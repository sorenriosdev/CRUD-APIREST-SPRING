package com.edu.cibertec.Crud_apiRest.dto;

public record CarDto(
        Integer cardId,
        String make,
        String model,
        Integer year,
        String engineType,
        String color
) {
}
