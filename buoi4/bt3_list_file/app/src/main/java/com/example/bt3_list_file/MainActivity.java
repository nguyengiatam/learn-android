package com.example.bt3_list_file;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    ArrayList<FileBook> listBook;
    RecyclerView view;
    AdapterListFile adater;
    Toolbar mainToolbar;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData();
        adater = new AdapterListFile(listBook,this);
        view = findViewById(R.id.rcv_list_file);
        view.setAdapter(adater);
        view.setLayoutManager(new LinearLayoutManager(this));
        setMainToolbar();
    }

    private void setMainToolbar(){
        mainToolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
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