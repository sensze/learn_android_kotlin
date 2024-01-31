package com.ifkusyoba.basic_intent

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ifkusyoba.basic_intent.data.Car

@Suppress("DEPRECATION")
class MoveWithObject2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object2)

        val tvObject2: TextView = findViewById(R.id.tv_object2_received)

        val car = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_CAR, Car::class.java)
        } else {
            intent.getParcelableExtra<Car>(EXTRA_CAR)
        }

        if (car != null) {
            val text =
                "Car name: ${car.name} \n Car model: ${car.model} \n Car weight: ${car.weight.toString()} \n Car color: ${car.color} \n Car transimission ${car.transmission}"
            tvObject2.text = text
        }
    }

    companion object {
        const val EXTRA_CAR = "extra_car"
    }
}