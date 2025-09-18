package com.csmath1

import kotlin.math.*

class Projectile(
    private val velocity: Double,   // initial velocity in m/s
    private val angleDeg: Double,   // launch angle in degrees
    private val mass: Double        // mass in kg (for later physics)
) {
    private val g = 9.8
    private val angleRad = Math.toRadians(angleDeg)

    // Position functions
    fun x(t: Double): Double = velocity * cos(angleRad) * t
    fun y(t: Double): Double = velocity * sin(angleRad) * t - 0.5 * g * t * t

    // Derivatives (velocity components)
    fun dxdt(): Double = velocity * cos(angleRad)
    fun dydt(t: Double): Double = velocity * sin(angleRad) - g * t

    // Second derivative (acceleration)
    fun d2ydt2(): Double = -g

    // Time until it hits the ground (solve y=0)
    fun flightTime(): Double = (2 * velocity * sin(angleRad)) / g

    // Max height (vertex of parabola)
    fun maxHeight(): Double = (velocity * velocity * sin(angleRad).pow(2)) / (2 * g)

    // Range (horizontal distance before hitting ground)
    fun range(): Double = velocity * velocity * sin(2 * angleRad) / g
}
