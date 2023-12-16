package ru.mtech.test.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.mtech.test.model.CarWheel
import ru.mtech.test.service.CarWheelService

@RestController
@RequestMapping("car_wheel")
class CarWheelController(
    private val service: CarWheelService
) {

    @GetMapping
    fun getAll(): List<CarWheel> {
        return service.getAll().toList()
    }
}