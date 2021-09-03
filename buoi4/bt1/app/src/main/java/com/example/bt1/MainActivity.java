package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener, View.OnClickListener {

    EditText phone, email, name, agency, password;
    Button input;
    CheckValue check = new CheckValue();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        setListener();
    }

    @Override
    public void onClick(View v) {
        if(check.allValue(String.valueOf(phone.getText()),String.valueOf(email.getText()),String.valueOf(name.getText()),String.valueOf(agency.getText()),String.valueOf(password.getText()))){
            Toast.makeText(this,"Cập nhật thông tin thành công",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Hãy hoàn thành các mục cần nhập",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus){
            ImageView view;
            switch (v.getId()){
                case R.id.edt_phone:
                    view = findViewById(R.id.check_phone);
                    if (check.phone(String.valueOf(phone.getText()))){
                        view.setImageResource(R.drawable.ic_true);
                    }else {
                        view.setImageResource(R.drawable.ic_false);
                    }
                    break;
                case R.id.edt_email:
                    view = findViewById(R.id.check_mail);
                    if (check.email(String.valueOf(email.getText()))){
                        view.setImageResource(R.drawable.ic_true);
                    }else {
                        view.setImageResource(R.drawable.ic_false);
                    }
                    break;
                case R.id.edt_full_name:
                    view = findViewById(R.id.check_name);
                    if (check.name(String.valueOf(name.getText()))){
                        view.setImageResource(R.drawable.ic_true);
                    }else {
                        view.setImageResource(R.drawable.ic_false);
                    }
                    break;
                case R.id.edt_agency:
                    view = findViewById(R.id.check_agency);
                    if (check.agency(String.valueOf(agency.getText()))){
                        view.setImageResource(R.drawable.ic_true);
                    }else {
                        view.setImageResource(R.drawable.ic_false);
                    }
                    break;
                case R.id.edt_password:
                    view = findViewById(R.id.check_password);
                    if (check.password(String.valueOf(password.getText()))){
                        view.setImageResource(R.drawable.ic_true);
                    }else {
                        view.setImageResource(R.drawable.ic_false);
                    }
                    break;
            }
        }
    }

    private void setView(){
        phone = findViewById(R.id.edt_phone);
        email = findViewById(R.id.edt_email);
        name = findViewById(R.id.edt_full_name);
        agency = findViewById(R.id.edt_agency);
        password = findViewById(R.id.edt_password);
        input = findViewById(R.id.bt_input);
    }

    private void setListener(){
        phone.setOnFocusChangeListener(this);
        email.setOnFocusChangeListener(this);
        name.setOnFocusChangeListener(this);
        agency.setOnFocusChangeListener(this);
        password.setOnFocusChangeListener(this);
        input.setOnClickListener(this);
    }
}