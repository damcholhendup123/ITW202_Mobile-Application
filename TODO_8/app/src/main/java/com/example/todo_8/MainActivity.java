package com.example.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.icu.text.LocaleDisplayNames;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {
    private EditText edt1;
    private EditText edt2;
    private EditText edt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.website);
        edt2 = findViewById(R.id.location);
        edt3 = findViewById(R.id.txt);
    }


    public void website(View view) {
        String web = edt1.getText().toString();
        Uri uri = Uri.parse(web);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        // if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
        //} else {
        //  Log.d("ImplicitIntents", "Can't handle this intent!");
        //}

    }

    public void location(View view) {
        String loc = edt2.getText().toString();
        Uri uri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        //if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
        // } else {
        //Log.d("ImplicitIntents", "Can't handle this intent!");
        //  }

    }

    public void share(View view) {
        String send = edt3.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("share this text with: ")
                .setText(send)
                .startChooser();
    }
}