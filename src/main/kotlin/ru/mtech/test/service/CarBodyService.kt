package ru.mtech.test.service

import org.springframework.stereotype.Service
import ru.mtech.test.model.CarBody
import ru.mtech.test.repository.CarBodyRepository

@Service
class CarBodyService(
    private val repository: CarBodyRepository
) {

    fun getAll(): Iterable<CarBody> = repository.findAll()
}