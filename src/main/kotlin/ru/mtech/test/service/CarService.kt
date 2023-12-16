package ru.mtech.test.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import ru.mtech.test.model.Car
import ru.mtech.test.repository.CarBodyRepository
import ru.mtech.test.repository.CarPagingRepository
import ru.mtech.test.repository.CarRepository
import ru.mtech.test.repository.CarWheelRepository

@Service
class CarService(
    private val carWheelRepository: CarWheelRepository,
    private val carBodyRepository: CarBodyRepository,
    private val carRepository: CarRepository,
    private val carPagingRepository: CarPagingRepository,
) {

    fun createCar(carBodyId: Long, carWheelId: Long, carWheelCount: Int, name: String): Result<Car> {
        val carBody = carBodyRepository.findById(carBodyId)
        if (carBody.isEmpty) {
            return Result.failure(Exception("Invalid carBodyId"))
        } else if (carBody.get().count < 1) {
            return Result.failure(Exception("Not enough car body"))
        }

        val carWheel = carWheelRepository.findById(carWheelId)
        if (carWheel.isEmpty) {
            return Result.failure(Exception("Invalid carWheelId"))
        } else if (carWheelCount < 2) {
            return Result.failure(Exception("Minimum wheel count is 2, got $carWheelCount"))
        } else if (carWheel.get().count < carWheelCount) {
            return Result.failure(Exception("Not enough car wheels ($carWheelCount) but have ${carWheel.get().count}"))
        }

        carBodyRepository.save(carBody.get().copy(count = carBody.get().count - 1))
        carWheelRepository.save(carWheel.get().copy(count = carWheel.get().count - carWheelCount))
        val car = carRepository.save(Car(
            carBodyId = carBodyId,
            carWheelId = carWheelId,
            wheelCount = carWheelCount,
            name = name
        ))

        return Result.success(car)
    }

    fun getCarById(id: Long): Result<Car> {
        carRepository.findById(id).let {
            return if (it.isEmpty) {
                Result.failure(Exception("Not found"))
            } else {
                Result.success(it.get())
            }
        }
    }

    fun getPage(pageNumber: Int = 0, pageSize: Int = 20): Page<Car> {
        val p = PageRequest.of(pageNumber - 1, pageSize)
        return carPagingRepository.findAll(p)
    }
}