package com.wcc.supertrunfo

class Card (
        val vehicle: Vehicle,
        val driver: Driver,
        val player: Player
) {
    val label: String = "Card ${player.name}"
    val maxVelocity = setMaxVelocity()
    val accelerationTime = vehicle.accelarationTime
    val passengers = setPassenger()
    val xP = initXP()

    private fun setMaxVelocity(): Int {
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

    private fun setPassenger(): Int {
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