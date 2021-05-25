package com.example.todo_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textview1);
    }

    public void StartTask(View view) {
        //put a message in the text view

        mTextView.setText("Napping...");
//start the asyncTask
        new SimpleAssyncTask(mTextView).execute();
    }
}