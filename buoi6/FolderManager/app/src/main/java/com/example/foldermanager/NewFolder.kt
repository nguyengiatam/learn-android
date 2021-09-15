package com.example.foldermanager

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.new_folder.*

class NewFolder : AppCompatActivity() {
    private lateinit var database: ProgramData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_folder)
        setToolbar()
        getDatabase()
        setEvenListenner()
    }

    private fun setToolbar() {
        setSupportActionBar(new_folder_toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setEvenListenner() {
        val moveToMain = Intent(this, Main::class.java)
        back_home.setOnClickListener { finish() }
        save_folder.setOnClickListener {
            if (input_new_name_folder.text.toString().trim().equals("")) {
                Toast.makeText(this, "Tên thư mục không được để trống", Toast.LENGTH_SHORT).show()
            } else {
                database.insertFolder(
                    input_new_name_folder.text.toString(),
                    input_new_description_folder.text.toString()
                )
                startActivity(moveToMain)
            }
        }
    }

    private fun getDatabase() {
        database = ProgramData(this, "folder")
    }
}