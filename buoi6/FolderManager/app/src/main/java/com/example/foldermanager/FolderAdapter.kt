package com.example.foldermanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_folder.view.*

class FolderAdapter(var context: Context, var list: MutableList<Folder>) : RecyclerView.Adapter<FolderAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameFolder: TextView = itemView.folder_name
        val descriptionFolder: TextView = itemView.folder_description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_folder, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var folder = list.get(position)
        holder.nameFolder.setText(folder.name)
        holder.descriptionFolder.setText(folder.description)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}