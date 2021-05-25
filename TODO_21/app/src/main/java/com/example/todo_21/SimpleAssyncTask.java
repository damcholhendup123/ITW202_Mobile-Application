package com.example.todo_21;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAssyncTask extends AsyncTask<Void,Void, String> {
    private WeakReference <TextView> mTextView;

    public SimpleAssyncTask(TextView tv){
        mTextView = new WeakReference<>(tv);
    }
    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200;
        //we are not writing the thread directly because of the limitations so we are using try and catch.


        try {
            Thread.sleep(s);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return "Awake at last after sleeping for "  + s + " milliseconds!";

    }

    @Override
    protected  void onPostExecute(String s){
        mTextView.get().setText(s);
    }
}
