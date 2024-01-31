package com.ifkusyoba.basic_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.ifkusyoba.basic_intent.data.Car
import com.ifkusyoba.basic_intent.data.Person

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        val btnMoveWithDataObject: Button = findViewById(R.id.btn_move_activity_object)
        val btnMoveWithDataObject2: Button = findViewById(R.id.btn_move_activity_object_2)
        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        tvResult = findViewById(R.id.tv_result)


        btnMoveActivity.setOnClickListener(this)
        btnMoveWithDataActivity.setOnClickListener(this)
        btnMoveWithDataObject.setOnClickListener(this)
        btnMoveWithDataObject2.setOnClickListener(this)
        btnDialPhone.setOnClickListener(this)
        btnMoveForResult.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            /*Move to another activity with intent*/
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, EmptyViewsActivity::class.java)
                startActivity(moveIntent)
            }
            /*Add data to next intent*/
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Ifku Syoba")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 21)
                startActivity(moveWithDataIntent)
            }
            /*Add data object With Parcelable*/
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Ifku Syoba",
                    21,
                    "ifkusyobaa@gmail.com",
                    "Surabaya"
                )
                val moveWithDataObjectIntent =
                    Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithDataObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithDataObjectIntent)
            }

            /*Add data object With Parcelable*/
            R.id.btn_move_activity_object_2 -> {
                val car = Car(
                    "Innova",
                    "Kijang",
                    1000,
                    "White",
                    "Manual"
                )
                val moveWithDataObjectIntent =
                    Intent(this@MainActivity, MoveWithObject2Activity::class.java)
                moveWithDataObjectIntent.putExtra(MoveWithObject2Activity.EXTRA_CAR, car)
                startActivity(moveWithDataObjectIntent)
            }

            /*Button implicit intent to dial phone*/
            R.id.btn_dial_number -> {
                val phoneNumber = "08121212121"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }
}