package com.example.todo_5_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String TAG=MainActivity2.class.getSimpleName();
    public static final String Extra_reply = "com.example.todo4";
    private TextView textview;
    private EditText mreply;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mreply=findViewById(R.id.edtext);
        textview = findViewById(R.id.txt);
        Intent intent =getIntent();
        String message =intent.getStringExtra(MainActivity.Extra_message);
        textview.setText(message);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"Started");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Resumed");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"Paused");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"Stopped");
    }
    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(TAG,"Restarted");

    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"Destroy");
    }
    public void reply(View view) {
        String reply =mreply.getText().toString();
        Intent intent=new Intent();
        intent.putExtra(Extra_reply,reply);
        setResult(RESULT_OK,intent);
        finish();

    }
}