package com.example.foldermanager

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ProgramData(context: Context, tableName: String) :
    SQLiteOpenHelper(context, "FolderManager.db", null, 1) {
    private var tableName: String = tableName

    override fun onCreate(p0: SQLiteDatabase?) {
        val query =
            "CREATE TABLE $tableName (id INTEGER PRIMARY KEY AUTOINCREMENT, name VAR CHAR(255) NOT NULL, description TEXT)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $tableName")
        onCreate(p0)
    }

    public fun getAll(): MutableList<Folder> {
        val db = readableDatabase
        val listFolder = mutableListOf<Folder>()
        val cursor = db.rawQuery("SELECT * FROM $tableName", null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            listFolder.add(Folder(cursor.getInt(0), cursor.getString(1), cursor.getString(2)))
            cursor.moveToNext()
        }
        cursor.close()
        return listFolder
    }

    public fun getObjectById(id: Int): Folder{
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $tableName WHERE id = ?", arrayOf(id.toString()))
        cursor.moveToFirst()
        var folder = Folder(cursor.getInt(0),cursor.getString(1),cursor.getString(2))
        cursor.close()
        return folder
    }

    public fun updateFolder(name: String, description: String, id: Int) {
        var db = writableDatabase
        db.execSQL(
            "UPDATE $tableName SET name = ?, description = ? where id = ?",
            arrayOf(name, description, id.toString())
        )
    }

    public fun insertFolder(name: String, description: String) {
        val db = writableDatabase
        db.execSQL(
            "INSERT INTO $tableName (name, description) VALUES (?, ?)",
            arrayOf(name, description)
        )
    }

    public fun deleteFolder(id: Int) {
        val db = writableDatabase
        db.execSQL("DELETE FROM $tableName WHERE id = ?", arrayOf(id.toString()))
    }

    public fun getCount(): Int {
        val db = readableDatabase
        val value = db.rawQuery("SELECT COUNT(*) FROM $tableName ", null)
        value.moveToFirst()
        var count = value.getInt(0)
        value.close()
        return count
    }

    public fun getMaxId(): Int {
        val db = readableDatabase
        val value = db.rawQuery("SELECT MAX(id) FROM $tableName ", null)
        value.moveToFirst()
        val max = value.getInt(0)
        value.close()
        return max
    }
}