package com.example.bt3_list_file;

public class FileBook {
    private int icon_file;
    private String file_name;
    private int menu;

    public FileBook(int icon_file, String file_name, int menu){
        this.icon_file = icon_file;
        this.file_name = file_name;
        this.menu = menu;
    }

    public int getIcon_file() {
        return icon_file;
    }

    public void setIcon_file(int icon_file) {
        this.icon_file = icon_file;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public int getMenu() {
        return menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }
}
