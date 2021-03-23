package com.example.todo_5_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public  static final String Extra_message="com.example.todo_4";
    public static final String TAG=MainActivity.class.getSimpleName();
    public static final int Text_Request=1;
    private TextView textheadView;
    private TextView textreplyview;
    private EditText editText;
    //private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");
        textheadView=findViewById(R.id.text_header_reply);
        textreplyview=findViewById(R.id.text_message_reply);
        editText = findViewById(R.id.edtext);

        if (savedInstanceState != null){
            boolean isVisible =savedInstanceState.getBoolean("reply_message");
            if (isVisible){
                textheadView.setVisibility(View.VISIBLE);
                textreplyview.setText(savedInstanceState.getString("reply_state_message"));
                textreplyview.setVisibility(View.VISIBLE);
            }
        }

    }

    public void send(View view) {
        Intent intent = new Intent(this,MainActivity2.class);

        String message = editText.getText().toString();
        intent.putExtra(Extra_message,message);
        startActivityForResult(intent,Text_Request);

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
    @Override
    public void onActivityResult(int request_code,int result_code,Intent data ){
        super.onActivityResult(request_code,result_code,data);
        if (request_code==Text_Request){
            if (result_code==RESULT_OK) {
                String reply = data.getStringExtra(MainActivity2.Extra_reply);

                textheadView.setVisibility(View.VISIBLE);
                textreplyview.setText(reply);
                textreplyview.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (textheadView.getVisibility()==View.VISIBLE){
            outState.putBoolean("reply_message",true);
            outState.putString("reply_state_message",textreplyview.getText().toString());
        }
    }
}