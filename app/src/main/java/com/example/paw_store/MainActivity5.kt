package com.example.paw_store

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import com.example.paw_store.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    var bind: ActivityMain5Binding? = null
    var bool: Boolean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMain5Binding.inflate(layoutInflater)
        val name = findViewById<EditText>(R.id.pass1)


        setContentView(bind?.root)
        val db2 = DHelper2(this)
        val cr = db2.gettext()


        if (cr!!.moveToFirst()) {
            if (cr.getString(0).isNotEmpty()) {

                this@MainActivity5.finish()
                startActivity(Intent(this@MainActivity5, MainActivity::class.java))
            }
        }
        bind?.button9?.setOnClickListener {




                    val pass = bind?.pass1?.text.toString()
                    val result = db2.setText1(pass)

                    if (TextUtils.isEmpty(pass)) {
                        Toast.makeText(this, "ENTER PASSWORD", Toast.LENGTH_LONG).show()
                        bool = false


                    } else {
                        bool = true
                        if (bool == true) {
                            this@MainActivity5.finish()
                            startActivity(Intent(this, MainActivity::class.java))


                        }
                    }
                }


            }

        }




