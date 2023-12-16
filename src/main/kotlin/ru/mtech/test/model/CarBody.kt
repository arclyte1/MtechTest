package ru.mtech.test.model

import jakarta.persistence.*

@Entity
data class CarBody(
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @Column
    val type: String,

    @Column
    val count: Int,
)
