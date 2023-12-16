package ru.mtech.test.service

import org.springframework.stereotype.Service
import ru.mtech.test.model.CarWheel
import ru.mtech.test.repository.CarWheelRepository

@Service
class CarWheelService(
    private val repository: CarWheelRepository
) {

    fun getAll(): Iterable<CarWheel> = repository.findAll()
}