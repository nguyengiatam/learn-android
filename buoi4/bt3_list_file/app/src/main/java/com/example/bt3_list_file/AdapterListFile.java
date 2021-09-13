package com.example.bt3_list_file;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterListFile extends RecyclerView.Adapter<AdapterListFile.MyViewHolder> {
    private ArrayList<FileBook> list;
    private Context isContext;
    private Dialog dialogMenu;

    public AdapterListFile(ArrayList<FileBook> list, Context isContext){
        this.list = list;
        this.isContext = isContext;
        dialogMenu = new Dialog(isContext);
        dialogMenu.setContentView(R.layout.menu_item);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.file_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FileBook isFile = list.get(position);
        holder.getIcon().setImageResource(isFile.getIcon_file());
        holder.getName().setText(isFile.getFile_name());
        holder.getMenu().setImageResource(isFile.getMenu());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private View itemView;
        private ImageView icon;
        private TextView name;
        private ImageView menu;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            icon = itemView.findViewById(R.id.imv_icon_file);
            name = itemView.findViewById(R.id.tv_file_name);
            menu = itemView.findViewById(R.id.imv_menu);
            setListener();

        }

        public ImageView getIcon() {
            return icon;
        }

        public void setIcon(ImageView icon) {
            this.icon = icon;
        }

        public TextView getName() {
            return name;
        }

        public void setName(TextView name) {
            this.name = name;
        }

        public ImageView getMenu() {
            return menu;
        }

        public void setMenu(ImageView menu) {
            this.menu = menu;
        }


        private void setListener(){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"File được mở",Toast.LENGTH_SHORT).show();
                }
            });

            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogMenu.show();
                    setListenerMenu();
                }
            });
        }

        private void setListenerMenu(){
            int position = getAdapterPosition();
            dialogMenu.findViewById(R.id.txv_delate).setOnClickListener(view -> {
                list.remove(position);
                notifyItemRemoved(position);
                dialogMenu.cancel();
            });
            dialogMenu.findViewById(R.id.txv_rename).setOnClickListener(view ->{
                dialogMenu.cancel();
                Dialog dialogRename = new Dialog(isContext);
                dialogRename.setContentView(R.layout.rename_item_dialog);
                dialogRename.show();
                setListenRename(dialogRename, position);
            });
        }

        private void setListenRename(Dialog dialog, int position){
            dialog.findViewById(R.id.agree_rename).setOnClickListener(v -> {
                EditText edt_rename = dialog.findViewById(R.id.edt_rename);
                if (!edt_rename.getText().toString().trim().equals("")){
                    list.get(position).setFile_name(edt_rename.getText().toString());
                    notifyItemChanged(position);
                }else {
                    Toast.makeText(isContext,"Tên file không thể để trống",Toast.LENGTH_SHORT).show();
                }
                dialog.cancel();
            });
        }
    }
}
