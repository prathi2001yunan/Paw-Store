package com.example.paw_store

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity2 : AppCompatActivity() {
    private var rec: RecyclerView?=null
    private var search: SearchView?=null
    private var db1: DHHRLPER?=null
    private var newArray: ArrayList<Datalist>?=null



    private var searchList:ArrayList<Datalist>?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        rec = findViewById(R.id.recycle)

        rec?.setHasFixedSize(true)
        db1 = DHHRLPER(this)
        search = findViewById(R.id.search)
        searchList = ArrayList()
        getRecycle()
        search?.queryHint = "SEARCH HERE"
        search?.isIconifiedByDefault=false
        search?.clearFocus()

        search?.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                search?.clearFocus()

                return true

            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(p0: String?): Boolean {
                searchList?.clear()
                val searchValue =p0?.toLowerCase(Locale.getDefault())
                if(searchValue!!.isNotEmpty()){
                    newArray?.forEach {
                        if (it.nam.toLowerCase(Locale.getDefault()).contains(searchValue)) {
                            searchList!!.add(it)
                        }
                    }

                    rec?.adapter?.notifyDataSetChanged()
                }
                else{
                    searchList?.clear()
                    searchList?.addAll(newArray!!)

                    rec?.adapter?.notifyDataSetChanged()
                }
                return false


            }

        })
    }




            private fun getRecycle() {
                val newcursor = db1!!.gettext()
                newArray = ArrayList<Datalist>()
                while (newcursor!!.moveToNext()) {
                    val uname = newcursor.getString(0)

                    val upass = newcursor.getString(1)

                    newArray?.add(Datalist(uname!!, upass!!))
                }
                searchList!!.addAll(newArray!!)
                val list6 = RecycleAdapter(searchList!!)

                rec?.adapter = list6

                list6.onItemclickListener(object :RecycleAdapter.onItemclickListener{
                    override fun onItemclick(position: Int) {
                        val intent = Intent(this@MainActivity2,MainActivity3::class.java)
                        intent.putExtra("nam",newArray!![position].nam)
                        intent.putExtra("pass",newArray!![position].pass)
                        startActivity(intent)


                    }

                })

            }


    }



