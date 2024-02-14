package com.example.proyectosqlite4simple

import android.content.ContentValues
import android.content.Context
import android.widget.Toast

class DataManager(context: Context) {

    private val dbHelper = DatabaseHelper(context) //da acdeso a recursos, a la base de datos, etc

    fun addName(nombre: String) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply { //contenvalues
            //permite almacenar claves, valor
            put(DatabaseHelper.COLUMN_NAME, nombre) //agrega una pareja clave, valor, la clave
            //en este caso es el nombre de la columna, el valor, el que introduzcamos
        }
        db.insert(DatabaseHelper.TABLE_NAME, null, values) //insertar el valor
        db.close()
    }

    fun getAllNames(context: Context): String {
        val db = dbHelper.readableDatabase
        // crea un cursor con el resultado de la consulta, los cursores son objetos que representan filas, columnas de una tabla
        val cursor = db.rawQuery("SELECT * FROM ${DatabaseHelper.TABLE_NAME}", null)
        val names = StringBuilder() //construye cadenas de caracteres

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
    fun deleteName(nombre: String) {
        val db = dbHelper.writableDatabase
        db.delete(DatabaseHelper.TABLE_NAME, "${DatabaseHelper.COLUMN_NAME}=?", arrayOf(nombre))
        db.close()
    }

    fun updateName(oldName: String, newName: String) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NAME, newName)
        }
        db.update(DatabaseHelper.TABLE_NAME, values, "${DatabaseHelper.COLUMN_NAME}=?", arrayOf(oldName))
        db.close()
    }



}

