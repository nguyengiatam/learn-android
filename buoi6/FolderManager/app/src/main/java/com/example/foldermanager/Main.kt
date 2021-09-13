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
                val addNewFolder = Intent(this, NewFolder::class.java)
                startActivity(addNewFolder)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setToolbar() {
        setSupportActionBar(main_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setDataListFolder(){
        listFolder.add(Folder("Tổng hợp tin tức thời sự","Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
        listFolder.add(Folder("Do It Your Self","Sơn Tùng MTP quá đẹp trai hát hay"))
        listFolder.add(Folder("Cảm hứng sáng tạo","Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
        listFolder.add(Folder("Tổng hợp tin tức thời sự","Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
        listFolder.add(Folder("Do It Your Self","Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
        listFolder.add(Folder("Cảm hứng sáng tạo","Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
        listFolder.add(Folder("Tổng hợp tin tức thời sự","Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các báo nổi nhất hiện nay"))
    }

    private fun setRcvFolder(){
        adapter = FolderAdapter(this,listFolder)
        rcv_main_folder.adapter = adapter
        rcv_main_folder.layoutManager = GridLayoutManager(this,1)
    }

    private fun setChangeLayout(){

    }

}