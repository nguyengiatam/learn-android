package com.example.bt1;

import java.util.regex.Pattern;

public class CheckValue {
    private Pattern format;

    public boolean phone(String value){
        format = Pattern.compile("^(\\+84|0)(3|5|7|8|9{1})\\d{8}$");
        return approve(value);
    }

    public boolean email(String value){
        format = Pattern.compile("^[\\w-_.]+@([\\w]+\\.)+[\\w]+$");
        return approve(value);
    }

    public boolean name(String value){
        format = Pattern.compile("^[\\w\\s]{3,100}$");
        return approve(value);
    }

    public boolean agency(String value){
        format = Pattern.compile("^[\\w\\s]{3,100}$");
        return approve(value);
    }

    public boolean password(String value){
        format = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=.*[a-z]).{8,}$");
        return approve(value);
    }

    public boolean allValue(String valuePhone, String valueEmail, String valueName, String valueAgency, String valuePassword){
        if (phone(valuePhone) && email(valueEmail) && name(valueName) && agency(valueAgency) && password(valuePassword)){
            return true;
        }
        return false;
    }

    private boolean approve(String value){
        if (format.matcher(value).find()){
            return true;
        }
        return false;
    }
}
