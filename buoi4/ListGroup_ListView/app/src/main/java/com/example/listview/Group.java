package com.example.listview;

public class Group {
    static int valueId = 1;
    private final int id;
    private int avatar;
    private String name;
    private int member;
    private int newPost;
    private String status;

    public Group(int avatar, String name, int member, int newPost, String status){
        id = ++valueId;
        this.avatar = avatar;
        this.name = name;
        this.member = member;
        this.newPost = newPost;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public int getNewPost() {
        return newPost;
    }

    public void setNewPost(int newPost) {
        this.newPost = newPost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
