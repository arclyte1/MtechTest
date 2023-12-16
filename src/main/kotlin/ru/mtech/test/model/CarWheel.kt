package ru.mtech.test.model

import jakarta.persistence.*

@Entity
data class CarWheel(
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @Column
    val size: String,

    @Column
    val count: Int,
)
