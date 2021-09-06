package com.example.listview;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class ListGroupAdapter extends BaseAdapter {

    private final ArrayList<Group> list;

    public ListGroupAdapter(ArrayList<Group> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewGroup ;
        if (convertView == null) {
            viewGroup = View.inflate(parent.getContext(), R.layout.list_group, null);
        } else {
            viewGroup = convertView;
        }

        Group isGroup = (Group) getItem(position);

        TextView status = viewGroup.findViewById(R.id.status_group);
        if (isGroup.getStatus().equals(MainActivity.STATUS_PRIVATE)){
            status.setTextColor(Color.parseColor("#FFCC00"));
        }else if (isGroup.getStatus().equals(MainActivity.STATUS_PUBLIC)){
            status.setTextColor(Color.parseColor("#00BBDD"));
        }else {
            status.setTextColor(Color.parseColor("#000000"));
        }
        status.setText(isGroup.getStatus());
        ((ImageView) viewGroup.findViewById(R.id.img)).setImageResource(isGroup.getAvatar());
        ((TextView) viewGroup.findViewById(R.id.name_group)).setText(isGroup.getName());
        ((TextView) viewGroup.findViewById(R.id.member_group)).setText(formatMember(isGroup.getMember()).concat(" Fan"));
        ((TextView) viewGroup.findViewById(R.id.new_post)).setText(formatPost(isGroup.getNewPost()).concat(" bài viết mới nhất"));

        return viewGroup;
    }

    private String formatMember(long value){
        String result = "";
        if(value < 1000){
            result = value + "";
        }else if (value < 1000000){
            result = value/1000 + "k";
        }else if (value < 1000000000){
            result = value/1000000 + "m";
        }else {
            result = value/1000000000 + "b";
        }
        return result;
    }

    private String formatPost(long value){
        String result = "";
        if(value < 10){
            result += value;
        }else if (value < 100){
            result = "+" + (value - value % 10);
        }else if (value < 1000){
            result ="+" + (value- value % 100);
        }else {
            result = "+" + (value - value % 1000);
        }
        return result;
    }
}
