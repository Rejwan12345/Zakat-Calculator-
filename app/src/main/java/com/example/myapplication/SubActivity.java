package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public class SubActivity extends AppCompatActivity {

    public static String UTTOR1 = "";
    public static String TITLE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        MaterialToolbar subMaterialToolbar = findViewById(R.id.SubMaterialToolbar);
        TextView uttor = findViewById(R.id.uttor);


        uttor.setText(UTTOR1);


        subMaterialToolbar.setTitle(TITLE);


        subMaterialToolbar.setNavigationOnClickListener(v -> finish());


    }

    @Override
    public void onBackPressed() {
        // startActivity(new Intent(SubActivity.this,ProshnoActivity.class));
        finish();

    }
}