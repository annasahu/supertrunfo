package com.wcc.supertrunfo.interactors

import com.wcc.supertrunfo.entities.Driver
import com.wcc.supertrunfo.entities.Player
import com.wcc.supertrunfo.entities.Vehicle

class Card (
        private val vehicle: Vehicle,
        private val driver: Driver,
        val player: Player = Player("player")
) {
    val label: String = "Card ${player.name}"
    val maxVelocity = initMaxVelocity()
    val accelerationTime = vehicle.accelarationTime
    val passengers = initPassenger()
    val xP = initXP()

    private fun initMaxVelocity(): Int {
        return when(vehicle.type) {
            "carro" -> carMaxValocity()
            "motorcycle" -> motorcycleMaxVelocity()
            else -> bikeMaxVelocity()
        }
    }

    private fun bikeMaxVelocity(): Int {
        return vehicle.maxAcceleration * driver.boldness
    }

    private fun motorcycleMaxVelocity(): Int {
        return 1 / vehicle.weight * vehicle.maxAcceleration
    }

    private fun carMaxValocity(): Int {
        return if(vehicle.style == "sedã"){
            vehicle.maxAcceleration
        } else {
            vehicle.maxAcceleration + 10
        }
    }

    private fun initPassenger(): Int {
        return vehicle.passagers * (1 + driver.defensiveDriving)
    }

    private fun initXP(): Int {
        return when (vehicle.type) {
            "car" -> driver.carXP
            "motorcycle" -> driver.motorcycleXP
            else -> driver.bikeXP
        }
    }
}