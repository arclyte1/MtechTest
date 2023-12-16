package ru.mtech.test.controller

import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*
import ru.mtech.test.model.Car
import ru.mtech.test.service.CarService

@RestController
@RequestMapping("car")
class CarController(
    private val service: CarService
) {

    @GetMapping("{id}")
    fun getById(
        @PathVariable id: Long
    ): Any {
        service.getCarById(id).onSuccess {
            return it
        }.onFailure {
            return it.message ?: "Unexpected error"
        }
        return ""
    }

    @PostMapping
    fun addCar(@RequestBody car: Car): Any {
        service.createCar(
            carBodyId = car.carBodyId,
            carWheelId = car.carWheelId,
            carWheelCount = car.wheelCount,
            name = car.name
        ).onSuccess {
            return it
        }.onFailure {
            return it.message ?: "Unexpected error"
        }
        return ""
    }

    @GetMapping
    fun getPage(
        @RequestParam("pageNumber", defaultValue = "1") pageNumber: Int,
        @RequestParam("pageSize", defaultValue = "20") pageSize: Int,
    ): Page<Car> {
        return service.getPage(pageNumber, pageSize)
    }
}