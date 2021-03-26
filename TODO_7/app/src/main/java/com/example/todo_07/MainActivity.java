package com.example.todo_07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private int mCount = 0;
private TextView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView=(TextView) findViewById(R.id.tv);
        if (savedInstanceState!=null){
            mView.setText(toString().valueOf(savedInstanceState.getInt("count")));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", mCount);
    }

    public void count(View view) {
        mCount++;
        if (mView !=null)
            mView.setText(Integer.toString(mCount));
        

    }
}