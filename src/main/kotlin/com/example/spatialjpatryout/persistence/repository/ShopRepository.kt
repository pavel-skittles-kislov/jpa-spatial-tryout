package com.example.spatialjpatryout.persistence.repository

import com.example.spatialjpatryout.persistence.entity.Shop
import com.example.spatialjpatryout.persistence.repository.projections.ShopProjection
import org.locationtech.jts.geom.Point
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository : JpaRepository<Shop, Long> {
    @Query(
        value = "select s.id, " +
                "s.name, " +
                "s.address, " +
                "s.working_hours, " +
                "round(" +
                "cast(st_distancesphere(position, :point) as numeric), 2) as distance, " +
                "s.lat, s.lon from shop s order by distance",
        nativeQuery = true
    )
    fun findAllShopsOrderedByDistance(@Param("point") point: Point): List<ShopProjection>
}
