package com.example.bt_buoi_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    EditText user, pass, re_pass;
    TextView msgUser, msgPass, msgRePass;
    Button input;
    Boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.edt_user);
        pass = findViewById(R.id.edt_pass);
        re_pass = findViewById(R.id.edt_re_pass);
        msgUser = findViewById(R.id.txt_msg_user);
        msgPass = findViewById(R.id.txt_msg_pass);
        msgRePass = findViewById(R.id.txt_msg_re_pass);
        input = findViewById(R.id.bt_input);
        listen();
    }

    @Override
    public void onClick(View v) {
        if (check){
            Toast.makeText(this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            checkInputValue(v);
            if (approve()){
                check = true;
            }
        }
    }

    private void checkInputValue(View v) {
        Pattern p;
        switch (v.getId()) {
            case R.id.edt_user:
                p = Pattern.compile("^[a-zA-Z0-9]{6,15}$");
                if (!p.matcher(String.valueOf(user.getText())).find()) {
                    msgUser.setText("Username sai định dạng yêu cầu");
                } else {
                    msgUser.setText("");
                }
                break;
            case R.id.edt_pass:
                p = Pattern.compile("((?=.[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20})");
                if (!p.matcher(String.valueOf(pass.getText())).find()) {
                    msgPass.setText("Password sai định dạng yêu cầu");
                } else {
                    msgPass.setText("");
                }
                break;
            case R.id.txt_msg_re_pass:
                if (msgPass.getText() != msgRePass.getText()) {
                    msgRePass.setText("Nhập lại không đúng mật khẩu");
                } else {
                    msgRePass.setText("");
                }
                break;
        }
    }

    private Boolean approve() {
        if (String.valueOf(msgUser.getText()).equals("") && String.valueOf(msgPass.getText()).equals("") && String.valueOf(msgRePass.getText()).equals("")) {
            return true;
        }
        return false;
    }

    private void listen() {
        user.setOnFocusChangeListener(this);
        pass.setOnFocusChangeListener(this);
        re_pass.setOnFocusChangeListener(this);
        input.setOnClickListener(this);
    }
}