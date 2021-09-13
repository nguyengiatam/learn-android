package com.example.bt4_list_folder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.MyViewHolder> {
    private ArrayList<Folder> list;
    private Context context;

    public FolderAdapter(ArrayList<Folder> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rcv_folder, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Folder thisFolder = list.get(position);
        holder.getIc_folder().setImageResource(R.drawable.ic_folder);
        holder.getName().setText(thisFolder.getName());
        holder.getIc_edit().setImageResource(R.drawable.ic_edit);
        holder.getIc_delete().setImageResource(R.drawable.ic_cancel);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final View itemView;
        private final TextView name;
        private final ImageView ic_folder;
        private final ImageView ic_edit;
        private final ImageView ic_delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            name = itemView.findViewById(R.id.folder);
            ic_folder = itemView.findViewById(R.id.ic_folder);
            ic_edit = itemView.findViewById(R.id.ic_edit);
            ic_delete = itemView.findViewById(R.id.ic_cancel);
            setListener();
        }

        public TextView getName() {
            return name;
        }

        public ImageView getIc_folder() {
            return ic_folder;
        }

        public ImageView getIc_edit() {
            return ic_edit;
        }

        public ImageView getIc_delete() {
            return ic_delete;
        }

        private void setListener(){
            ic_edit.setOnClickListener(v -> {
                int position = getAdapterPosition();
                setEvenListennerRenameFolder(position);
            });

            ic_delete.setOnClickListener(v -> {
                int position = getAdapterPosition();
                setEvenListennerDeleteFolder(position);
            });
        }

        private void setEvenListennerRenameFolder(int position){
            Dialog renameDialog = new Dialog(context);
            renameDialog.setContentView(R.layout.edit_name);
            renameDialog.show();
            EditText inputName = renameDialog.findViewById(R.id.edt_rename);
            inputName.setText(list.get(position).getName());
            renameDialog.findViewById(R.id.agree_rename).setOnClickListener(v -> {
                if (!inputName.getText().toString().trim().equals("")){
                    list.get(position).setName(inputName.getText().toString());
                    notifyItemChanged(position);
                    renameDialog.cancel();
                }else {
                    Toast.makeText(context,"Tên folder không được để trống", Toast.LENGTH_SHORT).show();
                }
            });

            renameDialog.findViewById(R.id.cancel_rename).setOnClickListener(v ->  {
                renameDialog.cancel();
            });
        }

        private  void setEvenListennerDeleteFolder(int position){

            AlertDialog.Builder deleteDialog = new AlertDialog.Builder(context);
            deleteDialog.setCancelable(false);
            deleteDialog.setIcon(R.drawable.ic_delete);
            deleteDialog.setTitle("Xóa thư mục");
            deleteDialog.setMessage("Bạn có muốn xóa thư mục này không?");

            deleteDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    list.remove(position);
                    notifyItemRemoved(position);
                    dialogInterface.cancel();
                }
            });
            deleteDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            deleteDialog.create().show();
        }
    }
}
