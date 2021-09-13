package com.example.bt4_list_folder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Folder> list = new ArrayList<>();
    RecyclerView view;
    FolderAdapter adapter;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData();
        dialog = new Dialog(MainActivity.this);
        view = findViewById(R.id.rcv_main);
        adapter = new FolderAdapter(list,this);
        view.setAdapter(adapter);
        view.setLayoutManager(new GridLayoutManager(this,1));
        setToolbar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        dialog.setContentView(R.layout.new_folder);
        setListenerNewFolder();
        dialog.show();
        return super.onOptionsItemSelected(item);
    }

    private void setListenerNewFolder(){
        EditText inputNewFolder = dialog.findViewById(R.id.edt_dl_new_folder);
        dialog.findViewById(R.id.cancel_dl_new_folder).setOnClickListener(v -> {
            dialog.cancel();
        });

        dialog.findViewById(R.id.agree_new_folder).setOnClickListener(v -> {
            String value = inputNewFolder.getText().toString();
            if (!value.trim().equals("")){
                list.add(new Folder(value));
                adapter.notifyItemInserted(list.size() - 1);
                dialog.cancel();
            }else{
                Toast.makeText(this,"Tên thư mục không được để trống",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setToolbar(){
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setData(){
        list.add(new Folder("Video"));
        list.add(new Folder("Android"));
        list.add(new Folder("Applock"));
        list.add(new Folder("Books"));
        list.add(new Folder("Map"));
        list.add(new Folder("New folder"));
        list.add(new Folder("New folder 1"));
        list.add(new Folder("Music"));
        list.add(new Folder("Picture"));



    }
}