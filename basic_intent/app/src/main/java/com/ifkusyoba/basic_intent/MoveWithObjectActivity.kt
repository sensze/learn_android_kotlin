package com.ifkusyoba.basic_intent

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ifkusyoba.basic_intent.data.Person

@Suppress("DEPRECATION")
class MoveWithObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject: TextView = findViewById(R.id.tv_object_received)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_PERSON, Person::class.java)
        } else {
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null) {
            val text =
                "Name: ${person.name.toString()}, \nAge: ${person.age.toString()}, \n Email: ${person.email.toString()}, \nLocation: ${person.city.toString()}"
            tvObject.text = text
        }
    }

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
}