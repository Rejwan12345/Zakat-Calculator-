package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.MaterialToolbar;

public class ShornoActivity extends AppCompatActivity implements NetworkStateReceiver.NetworkStateReceiverListener{

    private NetworkStateReceiver networkStateReceiver;
    MaterialToolbar materialToolbar;

    WebView webView;
    LottieAnimationView load , check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_shorno);

        materialToolbar= findViewById(R.id.materialToolbar);

        webView = findViewById(R.id.webView);
        load = findViewById(R.id.load);
        check=findViewById(R.id.check);




        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
               //setTitle("Loading...");
                setProgress(progress * 100); //Make the bar disappear after URL is loaded

                // Return the app name after finish loading
                if(progress ==100){
                    load.setVisibility(View.INVISIBLE);
                }else {
                    load.setVisibility(View.VISIBLE);
                }

            }
        });



        webView.setWebViewClient(new HelloWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.livepriceofgold.com/silver-price/bangladesh.html");


        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define your onclick behavior here
                // For example, you can go back to the previous screen
                startActivity(new Intent(ShornoActivity.this,MainActivity.class));
                finish();
            }
        });


        startNetworkBroadcastReceiver(ShornoActivity.this);

    }

    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    protected void onPause() {
        unregisterNetworkBroadcastReceiver(ShornoActivity.this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        registerNetworkBroadcastReceiver(ShornoActivity.this);
        super.onResume();
    }

    @Override
    public void networkAvailable() {

        webView.setVisibility(View.VISIBLE);
        check.setVisibility(View.GONE);
        //Toast.makeText(this, "back online", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void networkUnavailable() {

        webView.setVisibility(View.GONE);
        check.setVisibility(View.VISIBLE);
        Toast.makeText(this, "no internet connection", Toast.LENGTH_SHORT).show();
    }

    public void startNetworkBroadcastReceiver(Context currentContext) {
        networkStateReceiver = new NetworkStateReceiver();
        networkStateReceiver.addListener((NetworkStateReceiver.NetworkStateReceiverListener) currentContext);
        registerNetworkBroadcastReceiver(currentContext);
    }

    public void registerNetworkBroadcastReceiver(Context currentContext) {
        currentContext.registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }
    public void unregisterNetworkBroadcastReceiver(Context currentContext) {
        currentContext.unregisterReceiver(networkStateReceiver);
    }


    @Override
    public void onBackPressed() {
       // startActivity(new Intent(ShornoActivity.this,MainActivity.class));
        finish();
    }
}