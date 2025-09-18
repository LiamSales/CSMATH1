package com.csmath1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputAngle = findViewById<EditText>(R.id.inputAngle)
        val inputVelocity = findViewById<EditText>(R.id.inputVelocity)
        val inputMass = findViewById<EditText>(R.id.inputMass)
        val btnCompute = findViewById<Button>(R.id.btnCompute)
        val chart = findViewById<LineChart>(R.id.chart)

        btnCompute.setOnClickListener {
            val angle = inputAngle.text.toString().toDoubleOrNull() ?: 45.0
            val velocity = inputVelocity.text.toString().toDoubleOrNull() ?: 10.0
            val mass = inputMass.text.toString().toDoubleOrNull() ?: 1.0

            val projectile = Projectile(velocity, angle, mass)
            val timeOfFlight = projectile.flightTime()

            val entries = mutableListOf<Entry>()
            val steps = 100
            val dt = timeOfFlight / steps

            for (i in 0..steps) {
                val t = i * dt
                val x = projectile.x(t).toFloat()
                val y = projectile.y(t).toFloat()
                if (y >= 0) { // only plot above ground
                    entries.add(Entry(x, y))
                }
            }

            val dataSet = LineDataSet(entries, "Trajectory")
            dataSet.color = resources.getColor(android.R.color.holo_blue_dark, null)
            dataSet.setDrawCircles(false)

            chart.data = LineData(dataSet)
            chart.invalidate()
        }
    }
}
