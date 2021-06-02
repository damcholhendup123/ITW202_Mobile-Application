package com.example.todo_22;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils  {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    //BAse URL for books

    private static final String BOOK_BASE_URL ="https://www.googleapis.com/books/v1/volumes?";
//parameter for the search
    private static final String QUERY_PARAM = "q";

    //parameter that limits the search

    private static final String MAX_RESULTS = "maxResults";

    //parameter to filter the print type

    private  static final String PRINT_TYPE = "Printype";


    static String getBookInfo(String queryString){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String bookJSONString = null;

        try {
            Uri builtURI = Uri.parse(BOOK_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, queryString)
                    .appendQueryParameter(MAX_RESULTS, "10")
                    .appendQueryParameter(PRINT_TYPE, "books")
                    .build();

            URL requestURL = new URL(builtURI.toString());

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            //get the inputstream
            InputStream inputStream = urlConnection.getInputStream();
            //create a buffer reader from that inputstream
            reader = new BufferedReader(new InputStreamReader(inputStream));
            //use a Stringbuilder to hold the incoming response
            StringBuilder builder = new StringBuilder();

            String line;

            while ((line=reader.readLine())!=null){
                builder.append(line);
                //since it is a json, adding a new line isn't necessary
                //but it does make debugging a lot easier
                //if you print out the completed buffer for degugging
                builder.append('\n');


                if (builder.length()==0) {
                    //stream was empty. no point in parsing.
                    return null;
                }

                    bookJSONString = builder.toString();



            }
        }

        catch (IOException e) {
            e.printStackTrace();


        } finally {
            if (urlConnection != null){
                urlConnection.disconnect();
            }
            if (reader !=null){
                try {
                    reader.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
        Log.d(LOG_TAG, bookJSONString);

        return bookJSONString;

    }

}

