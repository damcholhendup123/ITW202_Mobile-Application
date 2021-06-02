package com.example.todo_22;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.ConnectException;

public class MainActivity extends AppCompatActivity
implements LoaderManager.LoaderCallbacks<String> {
    private EditText mBookInput;
    private TextView mTitleText;
    private TextView mAuthorText;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBookInput = (EditText)findViewById(R.id.bookInput);
        mTitleText = (TextView)findViewById(R.id.titleText);
        mAuthorText = (TextView)findViewById(R.id.authorText);

        if (getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }


    }

    public void searchBooks(View view) {
        String queryString = mBookInput.getText().toString();

        new Fetchbook(mTitleText,mAuthorText).execute(queryString);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null){
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        if (networkInfo!= null && networkInfo.isConnected()
        && queryString.length()!=0){
            Bundle querybundle = new Bundle();
            querybundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, querybundle,this);
            mAuthorText.setText("");
            mTitleText.setText("Loading");


        }
        else {
            if (queryString.length()==0){
                mAuthorText.setText("");
                mTitleText.setText("No search term");
            }
            else {
                mAuthorText.setText("");
                mTitleText.setText("no network");
            }
        }

    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryString = "";

        if (args != null){
            queryString = args.getString("queryString");
        }
        return new BookLoader(this,queryString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {

        // super.onPostExecute(data);

        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray itemsArray = jsonObject.getJSONArray("items");


            int i = 0;
            String title = null;
            String authors = null;

            while (i < itemsArray.length() &&
                    (authors == null && title == null)) {
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

            if (title != null && authors != null) {
                //since it is a weak reference we have to use get
                mTitleText.setText(title);
                mAuthorText.setText(authors);
            } else {
                mTitleText.setText("No result found");
                mAuthorText.setText("");
            }
        } catch (JSONException e) {
            mTitleText.setText("No result found");
            mAuthorText.setText("");
            e.printStackTrace();


        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}