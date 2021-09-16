package com.example.foldermanager

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.folder_information.view.*
import kotlinx.android.synthetic.main.list_folder.view.*

class FolderAdapter(var context: Context, var list: MutableList<Folder>) :
    RecyclerView.Adapter<FolderAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_folder, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val folder = list[position]
        holder.nameFolder.text = folder.name
        if (folder.description.equals("")) {
            holder.descriptionFolder.text = "Chưa có mô tả"
        } else {
            holder.descriptionFolder.text = folder.description
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener {
        val nameFolder: TextView = itemView.folder_name
        val descriptionFolder: TextView = itemView.folder_description

        init {
            setListenner()
        }

        override fun onClick(p0: View?) {
            val intent = Intent(context, EditFolder::class.java)
            intent.putExtra("id", list[adapterPosition].id)
            context.startActivity(intent)
        }

        override fun onLongClick(p0: View?): Boolean {
            val position = adapterPosition
            confirmDelete(position)
            return false
        }

        private fun setListenner() {
            itemView.item_folder.setOnClickListener(this)
            itemView.item_folder.setOnLongClickListener(this)
        }

        private fun confirmDelete(position: Int) {
            val deleteDialog = AlertDialog.Builder(context)
            deleteDialog.setIcon(R.drawable.ic_delete)
            deleteDialog.setTitle("Xóa thư mục")
            deleteDialog.setMessage("Bạn có muốn xóa thư mục này không?")
            deleteDialog.setPositiveButton(
                "Có",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    ProgramData(context, "folder").deleteFolder(list[position].id)
                    list.removeAt(position)
                    notifyItemRemoved(position)
                    dialogInterface.cancel()
                })

            deleteDialog.setNegativeButton(
                "Không",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    dialogInterface.cancel()
                })

            deleteDialog.create().show()
        }
    }
}