package com.example.paw_store

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.ProgressBar

class MainActivity6 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        var result:Int = 0

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity5::class.java))
            this@MainActivity6.finish()

        },3000)




    }
}