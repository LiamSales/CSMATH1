import kotlin.math.*
/*
to do: improve drag -- dxdt
learn why and how the derivatives work
use kotlin plotly for visualization
make a gui android app?
collision detection
variable gravity
 */



class Projectile(
    private val mass: Double,        // kg
    private val velocity: Double,    // m/s (initial velocity)
    private val angleDeg: Double,    // launch angle in degrees
    private val airResistance: Double
) {
    private val g = 9.8
    private val angleRad = Math.toRadians(angleDeg) // math functions such as sin and cos expect radians as arguments

    // Position functions
    fun x(t: Double): Double { //horizontal position at time t
        return velocity * cos(angleRad) * t// learn to implement air resistance
    }
//constant speed in x (research if true)

    fun y(t: Double): Double {
        // Simple version: no air resistance
        var yValue = velocity * sin(angleRad) * t - 0.5 * g * t * t
            // vertical position at time t ; up - down
        if (airResistance) {
            // Very basic drag: reduce height over time research for more accurscy
            val drag = 0.05 * t * velocity / mass
            yValue -= drag
        }

        return yValue
    }

    // Derivatives
    fun dxdt(): Double = velocity * cos(angleRad) // constant horizontal velocity
// change in horizontal motion in respect to time, constant for now but will have change with drag
    fun dydt(t: Double): Double {
        val base = velocity * sin(angleRad) - g * t
        return if (airResistance) base - 0.05 * velocity / mass else base
    }
    // i think somethings wrong; manuallly solve this tomorrow

    fun d2ydt2(): Double = -g // acceleration due to gravity (constant)
//double check this as well solve on paper tomorrow


    // Flight time (until y=0 again) total time in air
    fun flightTime(): Double {
        return (2 * velocity * sin(angleRad)) / g
    }

    // Maximum height
    fun maxHeight(): Double {
        return (velocity * velocity * sin(angleRad).pow(2)) / (2 * g)
    }

    // Range (horizontal distance before hitting ground)
    fun range(): Double {
        return velocity * velocity * sin(2 * angleRad) / g
    }

    // Slope (dy/dx) at time t (tangent of trajectory)
    fun slopeAt(t: Double): Double {
        return dydt(t) / dxdt()
    }
    //this needs proofreading too
}

// ---- Main Demo ----
fun main() {
    val projectile = Projectile(
        mass = 2.0,       // kg
        velocity = 20.0,  // m/s
        angleDeg = 45.0,  // degrees
        airResistance = false
    )

    println("Flight time: ${projectile.flightTime()} s")
    println("Max height: ${projectile.maxHeight()} m")
    println("Range: ${projectile.range()} m")

    val testTime = 1.0
    println("\nAt t=$testTime s:")
    println("x = ${projectile.x(testTime)} m")
    println("y = ${projectile.y(testTime)} m")
    println("dy/dt = ${projectile.dydt(testTime)} m/s")
    println("Slope (tangent) = ${projectile.slopeAt(testTime)}")
    println("Second derivative (acceleration) = ${projectile.d2ydt2()} m/s^2")
}

