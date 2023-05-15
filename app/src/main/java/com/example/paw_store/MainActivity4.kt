package com.example.paw_store

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.ThemedSpinnerAdapter.Helper
import com.example.paw_store.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    var bind: ActivityMain4Binding? = null
    private var pass2: String? = null
    private var db1: DHelper2? = null
    var bool:Boolean?=null

    @SuppressLint("Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(bind?.root)
        db1 = DHelper2(this)
        var text1 = bind?.pass1?.text
        val result: Cursor? =db1!!.gettext()
        if(result!!.moveToFirst()) {
             pass2 = result.getString(0)
        }






        bind?.button9?.setOnClickListener {





            if (text1.toString() == pass2.toString()) {
                bool=true
                this@MainActivity4.finish()
                startActivity(Intent(this, MainActivity2::class.java))
            } else {
                Toast.makeText(this, "WRONG PASSWORD", Toast.LENGTH_LONG).show()
                bool=false
            }
            bind?.pass1?.text?.clear()
        }



    }


    }
