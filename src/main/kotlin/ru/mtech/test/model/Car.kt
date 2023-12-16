package ru.mtech.test.model

import jakarta.persistence.*

@Entity
data class Car(
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @Column
    val carBodyId: Long,

    @Column
    val carWheelId: Long,

    @Column
    val wheelCount: Int,

    @Column
    val name: String,
)
