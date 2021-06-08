package com.example.spatialjpatryout.persistence.repository.projections

interface ShopProjection {
    fun getId(): Long
    fun getName(): String?
    fun getAddress(): String?
    fun getWorkingHours(): String?
    fun getDistance(): Double?
}