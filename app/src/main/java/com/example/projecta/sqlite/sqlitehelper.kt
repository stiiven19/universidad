package com.example.projecta.sqlite

import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.security.AccessControlContext

class sqlitehelper(context: android.content.Context) : SQLiteOpenHelper(
    context, "harmonydb", null, 1 ) {
    override fun onCreate(db: SQLiteDatabase?) {
        val ordencreacion = "CREATE TABLE problemas " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT)"
        db!!.execSQL(ordencreacion)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS problemas"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }

}