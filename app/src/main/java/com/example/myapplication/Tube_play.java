package com.example.myapplication;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Tube_play extends AppCompatActivity {


    public static String URL = "";
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tube_play);


        webView = findViewById(R.id.webView);


        webView.setWebViewClient(new HelloWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(URL);


    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private static class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(URL);
            return true;
        }
    }
}