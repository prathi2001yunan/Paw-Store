package com.example.paw_store

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.jar.Attributes.Name

class DHelper2(context:Context):SQLiteOpenHelper(context,"PASS",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE PASS(PASS TEXT)")


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun setText1(pass:String):Boolean{
        val db = this.writableDatabase
        val c = ContentValues()
        c.put("PASS",pass)
        val result = db.insert( "PASS", null, c)
        if(result==-1.toLong()){
            return false
        }
        return true
    }
    fun gettext(): Cursor? {

        val p0=this.writableDatabase
        val cursor = p0.rawQuery("SELECT * FROM PASS ",null)
        return cursor
    }
}
