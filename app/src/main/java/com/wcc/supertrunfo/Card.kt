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

    private fun setAccelerationTime(): Int {
        return vehicle.accelarationTime * (1 / driver.accelerationTime)
    }

    private fun setMaxVelocity(): Int {
        return 0
    }
}