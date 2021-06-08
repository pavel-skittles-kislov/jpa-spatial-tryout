package com.example.spatialjpatryout.service;

import com.example.spatialjpatryout.persistence.entity.Shop
import com.example.spatialjpatryout.persistence.repository.ShopRepository;
import com.example.spatialjpatryout.persistence.repository.projections.ShopProjection
import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.PrecisionModel
import org.springframework.stereotype.Service;

@Service
class ShopService(private val shopRepository: ShopRepository) {
    fun getClosestShop(lat: Double, lon: Double): ShopProjection? {
        return shopRepository.findAllShopsOrderedByDistance(geometryFactory.createPoint(Coordinate(lon, lat))).first()
    }

    fun getAllShopsOrderedByDistance(lat: Double, lon: Double): List<ShopProjection> {
        return shopRepository.findAllShopsOrderedByDistance(geometryFactory.createPoint(Coordinate(lon, lat)))
    }

    companion object {
        private const val SRID = 4326
        private val geometryFactory = GeometryFactory(PrecisionModel(), SRID)
    }
}
