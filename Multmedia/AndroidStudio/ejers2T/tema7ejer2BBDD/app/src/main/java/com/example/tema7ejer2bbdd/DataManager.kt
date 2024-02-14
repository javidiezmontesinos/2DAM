package com.example.tema7ejer2bbd

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.widget.Toast
import com.example.tema7ejer2bbdd.DatabaseHelper

class DataManager(context: Context) {
    private val dbHelper = DatabaseHelper(context)

    fun addName(nombre: String) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NAME, nombre)
        }
        db.insert(DatabaseHelper.TABLE_NAME, null, values)
        db.close()
    }

    fun addPassword(contraseña: String) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_PASSWORD, contraseña)
        }
        db.insert(DatabaseHelper.TABLE_NAME, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getAllNames(): String {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT ${DatabaseHelper.COLUMN_NAME} FROM ${DatabaseHelper.TABLE_NAME}", null)
        val names = StringBuilder()

        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME))
            names.append("$name\n")
        }

        cursor.close()
        db.close()

        if (names.isEmpty()) {
            return "No hay nombres en la base de datos"
        }

        return names.toString()
    }

    @SuppressLint("Range")
    fun getAllPasswords(): String {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT ${DatabaseHelper.COLUMN_PASSWORD} FROM ${DatabaseHelper.TABLE_NAME}", null)
        val passwords = StringBuilder()

        while (cursor.moveToNext()) {
            val password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PASSWORD))
            passwords.append("$password\n")
        }

        cursor.close()
        db.close()

        if (passwords.isEmpty()) {
            return "No hay contraseñas en la base de datos"
        }

        return passwords.toString()
    }}
