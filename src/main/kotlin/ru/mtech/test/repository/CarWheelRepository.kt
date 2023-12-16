package ru.mtech.test.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mtech.test.model.CarWheel

@Repository
interface CarWheelRepository : CrudRepository<CarWheel, Long>