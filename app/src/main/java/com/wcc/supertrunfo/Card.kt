package com.wcc.supertrunfo

class Card (
        val vehicle: Vehicle,
        val driver: Driver,
        val player: Player
) {
    val label: String = "Card ${player.name}"
    val maxVelocity = setMaxVelocity()
    val accelerationTime = setAccelerationTime()
    val passengers = setPassenger()

    private fun setPassenger(): Int {
        return vehicle.passagers * (1 + driver.defensiveDriving)
    }

    //criar
    private fun setAccelerationTime(): Int {
        TODO("Not yet implemented")
    }

    private fun setMaxVelocity(): Int {
        return 0
    }
}