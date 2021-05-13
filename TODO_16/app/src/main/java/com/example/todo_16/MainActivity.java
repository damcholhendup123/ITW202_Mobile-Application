package com.example.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mWorldList = new LinkedList<>();
    private RecyclerView mRecycleView;
    private WorldListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i =0; i<20; i++){
            mWorldList.addLast("Word"+ i);
        }

        mRecycleView = findViewById(R.id.recycleView);
        mAdapter = new WorldListAdapter(this,mWorldList);

        mRecycleView.setAdapter(mAdapter);
        LinearLayoutManager obj = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(obj);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int worldlistsize = mWorldList.size();
                //add a new word to the wordlist
                mWorldList.addLast("word" + worldlistsize);
                //Notify the adapter, that the data has changed
                mRecycleView.getAdapter().notifyItemInserted(worldlistsize);
                //scroll to the bottom
                mRecycleView.smoothScrollToPosition(worldlistsize);

            }
        });
    }
}