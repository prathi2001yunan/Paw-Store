package com.example.paw_store

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.paw_store.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private var binding:ActivityMain3Binding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding?.root)
        val intent1 = intent.getStringExtra("nam")
        val intent2 = intent.getStringExtra("pass")
        binding?.editText1?.setText(intent1)
        binding?.editText2?.setText(intent2)
        val db = DHHRLPER(this)
        binding?.imageView4?.setOnClickListener{
            val name = binding?.editText1?.text.toString()
            val delete = db.deleteText(name)
            if(delete == true){
                Toast.makeText(this@MainActivity3,"DELETED DATA",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this@MainActivity3,"DATA NOT DELETED",Toast.LENGTH_LONG).show()
            }

            this@MainActivity3.finish()





        }
        binding?.imageView5?.setOnClickListener {
            val name = binding?.editText1?.text.toString()
            val pass = binding?.editText2?.text.toString()
            val update = db.updateText(name, pass)
            if (update == true) {
                Toast.makeText(this@MainActivity3, "UPDATED DATA", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@MainActivity3, "DATA NOT UPDATED", Toast.LENGTH_LONG).show()
            }

            this@MainActivity3.finish()

        }






    }
}