package com.example.task3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_registration_form.*
import kotlinx.android.synthetic.main.activity_showprofile.*

class showprofile : AppCompatActivity() {

    private lateinit var homebtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showprofile)
        val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("name")
        val img = bundle!!.getInt("img")
        val email = bundle!!.getString("email")
                NAME.text = "Name: " + name
        EMAIL.text = "Email: " + email
        val gender = bundle!!.getString("gender")
        val time = bundle!!.getString("time")
        TIMEE.text= "time: " + time
        Gen.text = "Gender: " +gender
        imageView2.setImageResource(img)

        homebtn = findViewById(R.id.Back)


        homebtn.setOnClickListener {
            val backIntent = Intent(this, MainActivity::class.java)
            finish()
        }
    }
}