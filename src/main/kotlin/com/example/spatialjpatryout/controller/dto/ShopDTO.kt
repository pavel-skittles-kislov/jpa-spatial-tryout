package com.example.spatialjpatryout.controller.dto

import com.example.spatialjpatryout.persistence.repository.projections.ShopProjection

data class ShopDTO(
    val name: String?,
    val address: String?,
    val workingHours: String?,
    val distance: Double?
) {
    constructor(shop: ShopProjection) : this(
        name = shop.getName(),
        address = shop.getAddress(),
        workingHours = shop.getWorkingHours(),
        distance = shop.getDistance()
    )
}
