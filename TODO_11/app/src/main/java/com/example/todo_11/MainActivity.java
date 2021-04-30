package com.example.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView hello;
     private String [] mColorArray = {"maroon","gray", "blue", "chocolate",
             "purple", "_light_green", "brown",  };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello = findViewById(R.id.textView);
    }

    public void ChangeColor(View view) {
        Random random = new Random();
        String ColorName = mColorArray[random.nextInt(7)];

        int ColorResourceName = getResources().getIdentifier(ColorName, "color",
                getApplicationContext().getPackageName());

        int ColorRes = ContextCompat.getColor(this, ColorResourceName);
        hello.setTextColor(ColorRes);
    }
}