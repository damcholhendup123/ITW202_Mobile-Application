package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
private ImageView donut,iceCream,froyo;
private FloatingActionButton call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donut = findViewById(R.id.donut);
        iceCream = findViewById(R.id.ice);
        froyo = findViewById(R.id.froyo);
        call = findViewById(R.id.call);



    }

    public void donut(View view) {
        Toast.makeText(this, "You ordered a Donut!", Toast.LENGTH_SHORT).show();
    }

    public void iceCream(View view) {
        Toast.makeText(this, "You ordered an IceCream Sandwich!", Toast.LENGTH_SHORT).show();
    }

    public void froyo(View view) {
        Toast.makeText(this, "You ordered a Froyo!", Toast.LENGTH_SHORT).show();
    }

    public void Call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:17727644"));
        startActivity(intent);
    }
}