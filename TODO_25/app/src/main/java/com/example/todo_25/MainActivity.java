package com.example.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2, editText3, ID;
    private Button button1, button2, button3, button4;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);


        editText1 = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.editTextTextPersonName2);
        editText3 = findViewById(R.id.editTextTextPersonName3);
        ID = findViewById(R.id.editTextTextPersonName4);


        button1 = findViewById(R.id.add);
        button2 = findViewById(R.id.view);
        button3 = findViewById(R.id.update);
        button4 = findViewById(R.id.delete);

    }

    public void Add(View view) {
        boolean isInserted = myDB.insertData(ID.getText().toString(),
        editText1.getText().toString(),
        editText2.getText().toString(),
        editText3.getText().toString());

        if (isInserted == true)
            Toast.makeText(this,"Data Inserted", Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(this,"Data Not Inserted", Toast.LENGTH_SHORT).show();

    }

    public void viewall(View view) {
        Cursor res = myDB.getAllData();
        if (res.getCount()==0){
            showMessage("Error","Nothing Found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Student ID:" + res.getString(0)+"\n");
            buffer.append("First Name:" + res.getString(1)+"\n");
            buffer.append("Last Name:" + res.getString(2)+"\n");
            buffer.append("ITW202 Marks:" + res.getString(3)+"\n\n");

        }
        //show all data

        showMessage("List of Students",buffer.toString());

    }

    private void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();


    }

    public void update(View view) {
        boolean isUpdate = myDB.updateData(ID.getText().toString(),
        editText1.getText().toString(),
        editText2.getText().toString(),
                editText3.getText().toString());

        if (isUpdate == true)
            Toast.makeText(MainActivity.this, "Data Update", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data not Update", Toast.LENGTH_LONG).show();
    }

    public void delete(View view) {

        Integer deleterows = myDB.deleteData(ID.getText().toString());
        if (deleterows>0)
            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();



    }
}