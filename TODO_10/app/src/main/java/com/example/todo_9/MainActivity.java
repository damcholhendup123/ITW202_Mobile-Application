package com.example.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private TextView result;

    private Calculator calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        result = findViewById(R.id.textView);
        calculate = new Calculator();

    }

    public void Add(View view) {
        String value1 = editText1.getText().toString();
        String value2 = editText2.getText().toString();
        double Res = calculate.Add(Double.valueOf(value1), Double.valueOf(value2));
        result.setText(String.valueOf(Res));

    }

    public void Sub(View view) {

        String value1 = editText1.getText().toString();
        String value2 = editText2.getText().toString();
        double Res = calculate.Sub(Double.valueOf(value1), Double.valueOf(value2));
        result.setText(String.valueOf(Res));
    }

    public void Mul(View view) {
        String value1 = editText1.getText().toString();
        String value2 = editText2.getText().toString();
        double Res = calculate.Mul(Double.valueOf(value1), Double.valueOf(value2));
        result.setText(String.valueOf(Res));


    }

    public void Div(View view) {

        String value1 = editText1.getText().toString();
        String value2 = editText2.getText().toString();
        double Res = calculate.Div(Double.valueOf(value1), Double.valueOf(value2));
        result.setText(String.valueOf(Res));
    }
}