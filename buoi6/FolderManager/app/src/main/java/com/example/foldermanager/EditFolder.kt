package com.example.foldermanager

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.folder_information.*

class EditFolder : AppCompatActivity() {
    var id: Int = 0
    private val data = ProgramData(this, "folder")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.folder_information)
        setToolbar()
        setValue()
        setEvenListenner()
    }

    private fun setToolbar() {
        setSupportActionBar(folder_toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        title_toolbar_folder.setText("Chỉnh sửa")
    }

    private fun setValue() {
        id = intent.getIntExtra("id", 1)
        val folder = data.getObjectById(id)
        name_folder.setText(folder.name)
        description_folder.setText(folder.description)
    }

    private fun setEvenListenner() {
        val moveToMain = Intent(this, Main::class.java)
        back_home.setOnClickListener { finish() }
        save_folder.setOnClickListener {
            if (name_folder.text.toString().trim().equals("")) {
                Toast.makeText(this, "Tên thư mục không được để trống", Toast.LENGTH_SHORT).show()
            } else {
                data.updateFolder(
                    name_folder.text.toString(),
                    description_folder.text.toString(),
                    id
                )
                startActivity(moveToMain)
            }
        }
    }

}