package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Group> list;
    ListView listViewGroup;
    ListGroupAdapter adapter;
    public static final String STATUS_PRIVATE = "NHÓM KÍN";
    public static final String STATUS_PUBLIC = "NHÓM MỞ";
    public static final String STATUS_CLOSE = "NHÓM ĐÓNG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        getData();
        adapter = new ListGroupAdapter(list);
        listViewGroup = findViewById(R.id.list_group);
        listViewGroup.setAdapter(adapter);
    }

    private void getData(){
        list = new ArrayList<>();
        list.add(new Group(R.drawable.android1,"Mua bán có tâm",8432,14,STATUS_CLOSE));
        list.add(new Group(R.drawable.android2,"Ăn để lăn",1745,18,STATUS_PRIVATE));
        list.add(new Group(R.drawable.android3,"Chia sẻ kiển thức tài liệu",8432,14,STATUS_PUBLIC));
        list.add(new Group(R.drawable.android4,"Thực đơn Eat - Clear giảm cân khỏe đẹp",11842,26,STATUS_PUBLIC));
        list.add(new Group(R.drawable.android5,"Easy Kento for bussy People",8432,14,STATUS_PRIVATE));
        list.add(new Group(R.drawable.android6,"OFFB",8132,14,STATUS_PUBLIC));
        list.add(new Group(R.drawable.android7,"Thực đơn Eat - Clear giảm cân khỏe đẹp",11842,26,STATUS_PUBLIC));
    }
}