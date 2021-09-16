package com.example.foldermanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.main.*

class Main : AppCompatActivity() {
    lateinit var adapter : FolderAdapter
    var listFolder = mutableListOf<Folder>()
    val data = ProgramData(this, "folder")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        setToolbar()
        setDataListFolder()
        setRcvFolder()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.new_folder_main -> {
                var addNewFolder = Intent(this, NewFolder::class.java)
                startActivity(addNewFolder)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setToolbar() {
        setSupportActionBar(main_toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setRcvFolder(){
        adapter = FolderAdapter(this,listFolder)
        rcv_main_folder.adapter = adapter
        rcv_main_folder.layoutManager = GridLayoutManager(this,1)
    }

    private fun setDataListFolder(){
        listFolder = data.getAll()
    }

}