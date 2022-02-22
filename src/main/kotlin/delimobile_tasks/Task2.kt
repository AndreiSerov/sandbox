package delimobile_tasks


import java.util.*

enum class CarEngineStatus { TurnedOn, TurnedOff, AutoStart }

enum class CarEngineOilStatus { Low, Normal }

interface CarEngine {

    fun model(): String

    fun manufacturedAt(): Date

    fun nextMaintenanceDate(): Date


    fun oilPressure(): CarEngineOilStatus

    fun turnOn(): Boolean

    fun status(): CarEngineStatus

    fun turnOff(): Boolean

    fun temperatureF(): Int

}

/**
 *
 * interface segration
 *
 *
 *
 */

class Ride(val engine: CarEngine) {

    fun goForARide() {
        engine.turnOn()
        //@TODO
        engine.turnOff()
    }
}

/**
 * нужно ли делить CarEngine
 *
 *
 */


/**
 *
 * pattern компоновщик
 *
 *
 */

class EngineStatusCheck(val engine: CarEngine) {

    val normalTempInterval = Pair(1000, 10000)

    fun check(): Boolean {
        val (min, max) = normalTempInterval


        if (engine.temperatureF() > max) {
            //@TODO
        }

        if (engine.temperatureF() < min) {
            //@TODO
        }

//        if (engine.nextMaintenanceDate() > ...) {
//            //@TODO
//        }
//
//        if (engine.oilPressure() ... ) {
//            //@TODO
//        }

        return true // @TODO return valid result
    }
}