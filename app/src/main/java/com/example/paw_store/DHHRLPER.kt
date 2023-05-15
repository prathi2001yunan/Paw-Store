package com.example.paw_store

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.jar.Attributes.Name

class DHHRLPER(context:Context):SQLiteOpenHelper(context,"USERDB",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
      p0?.execSQL("CREATE TABLE USERDB(NAME TEXT,PASSWD TEXT)")
        p0?.execSQL("CREATE TABLE PASS(PASS TEXT)")
        p0?.execSQL("INSERT INTO PASS(PASS) VALUES('1234')")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
    fun settext(name:String , passwd:String):Boolean{
        var p0 = this.writableDatabase
        var c =ContentValues()
        c.put("NAME",name)
        c.put("PASSWD",passwd)

        val result = p0.insert("USERDB",null,c)
        if(result==-1.toLong()) {
            return false
        }

            return true


    }

    fun updateText(name:String,passwd:String):Boolean {
        val db = this.writableDatabase
        val c = ContentValues()
        c.put("NAME",name)
        c.put("PASSWD",passwd)
        val count:Cursor= db.rawQuery("SELECT * FROM USERDB WHERE NAME=?", arrayOf(name))
        if(count.count>0){
            val result = db.update("USERDB",c,"NAME=?", arrayOf(name))
            return result!=-1
        }
        else{
            return false
        }
    }
    fun deleteText(name:String):Boolean {
        val db = this.writableDatabase


        val count:Cursor= db.rawQuery("SELECT * FROM USERDB WHERE NAME=?", arrayOf(name))
        if(count.count>0){
            val result = db.delete("USERDB","NAME=?", arrayOf(name))
            return true
        }
        else{
            return false
        }
    }
    fun gettext(): Cursor? {

        val p0=this.writableDatabase
        val cursor = p0.rawQuery("SELECT * FROM USERDB",null)
        return cursor
    }

}