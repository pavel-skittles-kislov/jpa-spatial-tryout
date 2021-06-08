package com.example.spatialjpatryout.persistence.entity

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Point
import org.locationtech.jts.geom.PrecisionModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.SEQUENCE
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "shop")
data class Shop(
    @Id
    @SequenceGenerator(
        name = "ID_GENERATOR",
        sequenceName = "shop_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = SEQUENCE,
        generator = "ID_GENERATOR"
    )
    var id: Long? = null,

    val name: String?,

    val address: String?,

    @Column(nullable = false)
    val lat: Double,

    @Column(nullable = false)
    val lon: Double,

    val workingHours: String?,
) {
    @Column(columnDefinition = "geometry(Point,$SRID)", nullable = false)
    val position: Point = geometryFactory.createPoint(Coordinate(lon, lat))

    companion object {
        private const val SRID = 4326
        private val geometryFactory: GeometryFactory = GeometryFactory(PrecisionModel(), SRID)
    }
}
