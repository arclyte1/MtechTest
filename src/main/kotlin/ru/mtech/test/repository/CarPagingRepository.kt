package ru.mtech.test.repository

import org.springframework.data.repository.PagingAndSortingRepository
import ru.mtech.test.model.Car

interface CarPagingRepository : PagingAndSortingRepository<Car, Long>