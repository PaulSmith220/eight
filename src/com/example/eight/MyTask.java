package com.example.eight;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class MyTask extends AsyncTask<String,String,Void> {
    @Override
    protected Void doInBackground(String... params) {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            String url = params[0];
            HttpGet httpGet = new HttpGet(url);
            httpClient.execute(httpGet);

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}