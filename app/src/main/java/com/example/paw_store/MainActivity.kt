package com.example.paw_store

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private var name: EditText?=null
    private var passwd: EditText?=null
    private var but2: MaterialButton?=null
    private var but1: FrameLayout?=null
    private var db: DHHRLPER?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.editText1)
        passwd = findViewById(R.id.editText2)
        but2 = findViewById(R.id.button1)
        but1 =findViewById(R.id.fram1)
         db = DHHRLPER(this)

        but1?.setOnClickListener {
            var name1 = name?.text.toString()
            var passwd1 = passwd?.text.toString()
            var savedata = db?.settext(name1,passwd1)
            if(TextUtils.isEmpty(name1) || TextUtils.isEmpty(passwd1)){
                Toast.makeText(this,"Enter name & passwd ",Toast.LENGTH_LONG).show()
            }
            else {
                if (savedata == true) {
                    Toast.makeText(this, "name and passwd entered successfully", Toast.LENGTH_LONG)
                        .show()
                }
                else{
                    Toast.makeText(this, "exist contact", Toast.LENGTH_LONG)
                        .show()
                }

            }
            name?.text?.clear()
            passwd?.text?.clear()




        }
        but2?.setOnClickListener {
            startActivity(Intent(this,MainActivity4::class.java))
        }
    }
}