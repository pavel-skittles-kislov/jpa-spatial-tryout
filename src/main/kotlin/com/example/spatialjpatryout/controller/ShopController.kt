package com.example.spatialjpatryout.controller

import com.example.spatialjpatryout.controller.dto.ShopDTO
import com.example.spatialjpatryout.service.ShopService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/offices")
class ShopController(
    private val shopService: ShopService
) {
    @GetMapping("/distance/closest")
    fun getClosestShop(
        @RequestParam("lat", required = true) lat: Double,
        @RequestParam("lon", required = true) lon: Double
    ) = shopService.getClosestShop(lat, lon)?.let { ShopDTO(it) }

    @GetMapping("/distance/all")
    fun getShopsOrderedByDistance(
        @RequestParam("lat", required = true) lat: Double,
        @RequestParam("lon", required = true) lon: Double
    ) = shopService.getAllShopsOrderedByDistance(lat, lon).map { ShopDTO(it) }
}