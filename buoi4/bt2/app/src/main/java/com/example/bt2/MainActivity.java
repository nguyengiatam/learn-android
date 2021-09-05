package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView first_operator, calculation, last_operator;
    Boolean checkResult = false;
    double firstValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        setView();
        setListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_00:
            case R.id.bt_01:
            case R.id.bt_02:
            case R.id.bt_03:
            case R.id.bt_04:
            case R.id.bt_05:
            case R.id.bt_06:
            case R.id.bt_07:
            case R.id.bt_08:
            case R.id.bt_09:
            case R.id.bt_dots:
                if (checkResult) {
                    calculation.setText("");
                    first_operator.setText("");
                    checkResult = false;
                }
                last_operator.setText(String.valueOf(last_operator.getText()).concat(String.valueOf(((Button) v).getText())));
                break;
            case R.id.bt_addition:
            case R.id.bt_subtraction:
            case R.id.bt_multiplication:
            case R.id.bt_division:
            case R.id.bt_remainder:
                if (String.valueOf(last_operator.getText()).equals(".")) {
                    Toast.makeText(this, "Sai định dạng", Toast.LENGTH_SHORT).show();
                } else if (String.valueOf(first_operator.getText()).equals("") && !String.valueOf(last_operator.getText()).contains("√")) {
                    if (!String.valueOf(last_operator.getText()).equals("") ) {
                        firstValue = Double.parseDouble(String.valueOf(last_operator.getText()));
                    } else {
                        break;
                    }
                } else if (!String.valueOf(last_operator.getText()).equals("")) {
                    calculate(v);
                }
                checkResult = false;
                setValueAfterCalculation(v);
                break;
            case R.id.bt_result:
                if (String.valueOf(last_operator.getText()).equals(".")) {
                    Toast.makeText(this, "Sai định dạng", Toast.LENGTH_SHORT).show();
                } else if (!String.valueOf(first_operator.getText()).equals("") || String.valueOf(last_operator.getText()).contains("√")) {
                    calculate(v);
                    setValueAfterCalculation(v);
                } else {
                    break;
                }
                checkResult = true;
                break;
            case R.id.bt_clear:
                if (!String.valueOf(last_operator.getText()).equals("")) {
                    last_operator.setText(String.valueOf(last_operator.getText()).substring(0, String.valueOf(last_operator.getText()).length() - 1));
                }
                break;
            case R.id.bt_clear_all:
                last_operator.setText("");
                first_operator.setText("");
                calculation.setText("");
                break;
            case R.id.bt_square_root:
                if (String.valueOf(last_operator.getText()).equals("")) {
                    last_operator.setText("√");
                } else {
                    Toast.makeText(this, "Sai định dạng", Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void setListener() {
        findViewById(R.id.bt_00).setOnClickListener(this);
        findViewById(R.id.bt_01).setOnClickListener(this);
        findViewById(R.id.bt_02).setOnClickListener(this);
        findViewById(R.id.bt_03).setOnClickListener(this);
        findViewById(R.id.bt_04).setOnClickListener(this);
        findViewById(R.id.bt_05).setOnClickListener(this);
        findViewById(R.id.bt_06).setOnClickListener(this);
        findViewById(R.id.bt_07).setOnClickListener(this);
        findViewById(R.id.bt_08).setOnClickListener(this);
        findViewById(R.id.bt_09).setOnClickListener(this);
        findViewById(R.id.bt_dots).setOnClickListener(this);
        findViewById(R.id.bt_addition).setOnClickListener(this);
        findViewById(R.id.bt_multiplication).setOnClickListener(this);
        findViewById(R.id.bt_subtraction).setOnClickListener(this);
        findViewById(R.id.bt_division).setOnClickListener(this);
        findViewById(R.id.bt_result).setOnClickListener(this);
        findViewById(R.id.bt_clear).setOnClickListener(this);
        findViewById(R.id.bt_clear_all).setOnClickListener(this);
        findViewById(R.id.bt_remainder).setOnClickListener(this);
        findViewById(R.id.bt_square_root).setOnClickListener(this);
    }

    private void setView() {
        first_operator = findViewById(R.id.first_operator);
        calculation = findViewById(R.id.calculation);
        last_operator = findViewById(R.id.last_operator);
    }

    private void calculate(View v) {
        switch (String.valueOf(calculation.getText())) {
            case "+":
                if (String.valueOf(last_operator.getText()).indexOf("√") == 0) {
                    firstValue += Math.sqrt(Double.parseDouble(String.valueOf(last_operator.getText()).substring(1)));
                } else {
                    firstValue += Double.parseDouble(String.valueOf(last_operator.getText()));
                }
                break;
            case "-":
                if (String.valueOf(last_operator.getText()).indexOf("√") == 0) {
                    firstValue -= Math.sqrt(Double.parseDouble(String.valueOf(last_operator.getText()).substring(1)));
                } else {
                    firstValue -= Double.parseDouble(String.valueOf(last_operator.getText()));
                }
                break;
            case "*":
                if (String.valueOf(last_operator.getText()).indexOf("√") == 0) {
                    firstValue *= Math.sqrt(Double.parseDouble(String.valueOf(last_operator.getText()).substring(1)));
                } else {
                    firstValue *= Double.parseDouble(String.valueOf(last_operator.getText()));
                }
                break;
            case "÷":
                if (String.valueOf(last_operator.getText()).indexOf("√") == 0) {
                    firstValue /= Math.sqrt(Double.parseDouble(String.valueOf(last_operator.getText()).substring(1)));
                } else if (Double.parseDouble(String.valueOf(last_operator.getText())) == 0) {
                    Toast.makeText(this, "Không thể thực hiện phép chia cho 0", Toast.LENGTH_SHORT).show();
                } else {
                    firstValue /= Double.parseDouble(String.valueOf(last_operator.getText()));
                }
                break;
            case "%":
                if (String.valueOf(last_operator.getText()).indexOf("√") == 0) {
                    firstValue %= Math.sqrt(Double.parseDouble(String.valueOf(last_operator.getText()).substring(1)));
                } else if (Double.parseDouble(String.valueOf(last_operator.getText())) == 0) {
                    Toast.makeText(this, "Không thể thực hiện phép chia cho 0", Toast.LENGTH_SHORT).show();
                } else {
                    firstValue %= Double.parseDouble(String.valueOf(last_operator.getText()));
                }
                break;
            case "":
                if (String.valueOf(last_operator.getText()).indexOf("√") == 0) {
                    firstValue = Math.sqrt(Double.parseDouble(String.valueOf(last_operator.getText()).substring(1)));
                }
                break;
        }
    }

    private void setValueAfterCalculation(View v) {
        first_operator.setText(String.valueOf(firstValue));
        last_operator.setText("");
        calculation.setText(((Button) v).getText());
    }
}