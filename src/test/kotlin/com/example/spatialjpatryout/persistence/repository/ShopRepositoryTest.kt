package com.example.spatialjpatryout.persistence.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.PrecisionModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ShopRepositoryTest {
    @Autowired
    private lateinit var shopRepository: ShopRepository

    @Test
    fun `findAll should return right shops`() {
        // given
        val expectedShopsCount = 6

        // when
        val result = shopRepository.findAll()

        // then
        assertEquals(expectedShopsCount, result.size)
    }

    @Test
    fun `findAllShopsOrderedByDistance returns`() {
        // given
        val pointToOrderFrom = geometryFactory.createPoint(Coordinate(37.6211812, 55.7538337))
        val orderedIds = listOf(1L, 2L, 6L, 3L, 5L, 4L)
        val orderedNames = listOf(
            "Липовый мед Илъича",
            "Холодный холод",
            "Мороженное Хинкали",
            "Байкальский лед",
            "Вкус Гулага",
            "Сахалинские дали"
        )

        // when
        val result = shopRepository.findAllShopsOrderedByDistance(pointToOrderFrom)
        val actualIds = result.map { it.getId() }
        val actualNames = result.map { it.getName() }

        // then
        assertEquals(orderedIds, actualIds)
        assertEquals(orderedNames, actualNames)
    }

    companion object {
        private const val SRID = 4326
        private val geometryFactory: GeometryFactory = GeometryFactory(PrecisionModel(), SRID)
    }
}