package com.example.todo_22;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class Fetchbook extends AsyncTask<String, Void, String> {
    private WeakReference<TextView> mTitleText;
    private WeakReference<TextView> mAuthorText;


    Fetchbook (TextView titleText, TextView authorText) {
        this.mTitleText = new WeakReference<>(titleText);
        this.mAuthorText = new WeakReference<>(authorText);
    }
    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getBookInfo(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");


            int i =0;
            String title = null;
            String authors = null;

            while (i < itemsArray.length()&&
                    (authors==null && title ==null)) {
                //get the current item information

                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                //try to get the author and the title from the current item
                //catch if either field is empty and move on

                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e) {
                    e.printStackTrace();

                }


                //move to the next item
                i++;
            }

            if (title != null && authors !=null){
                //since it is a weak reference we have to use get
                mTitleText.get().setText(title);
                mAuthorText.get().setText(authors);
            }
            else {
                mTitleText.get().setText("No result found");
                mAuthorText.get().setText("");
            }
        }
        catch (JSONException e){
            mTitleText.get().setText("No result found");
            mAuthorText.get().setText("");
            e.printStackTrace();




        }

    }





}
