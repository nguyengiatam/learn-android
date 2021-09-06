package com.example.bt3_list_file;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContextMenu.ContextMenuInfo {
    ArrayList<FileBook> listBook;
    RecyclerView view;
    AdapterListFile adater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        setData();
        adater = new AdapterListFile(listBook,this);
        view = findViewById(R.id.rcv_list_file);
        view.setAdapter(adater);
        view.setLayoutManager(new LinearLayoutManager(this));
    }


    public void setData(){
        listBook = new ArrayList<>();
        listBook.add(new FileBook(R.drawable.ic_file, "To Kill a MocKingbird",R.drawable.ic_more_vert));
        listBook.add(new FileBook(R.drawable.ic_file, "To Kill a MocKingbird",R.drawable.ic_more_vert));
        listBook.add(new FileBook(R.drawable.ic_file, "To Kill a MocKingbird",R.drawable.ic_more_vert));
        listBook.add(new FileBook(R.drawable.ic_file, "To Kill a MocKingbird",R.drawable.ic_more_vert));
        listBook.add(new FileBook(R.drawable.ic_file, "To Kill a MocKingbird",R.drawable.ic_more_vert));
        listBook.add(new FileBook(R.drawable.ic_file, "To Kill a MocKingbird",R.drawable.ic_more_vert));
        listBook.add(new FileBook(R.drawable.ic_file, "To Kill a MocKingbird",R.drawable.ic_more_vert));
        listBook.add(new FileBook(R.drawable.ic_file, "To Kill a MocKingbird",R.drawable.ic_more_vert));
        listBook.add(new FileBook(R.drawable.ic_file, "To Kill a MocKingbird",R.drawable.ic_more_vert));
    }
}