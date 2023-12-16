package ru.mtech.test.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.mtech.test.model.CarBody
import ru.mtech.test.service.CarBodyService

@RestController
@RequestMapping("car_body")
class CarBodyController(
    private val service: CarBodyService
) {

    @GetMapping
    fun getAll(): List<CarBody> {
        return service.getAll().toList()
    }
}