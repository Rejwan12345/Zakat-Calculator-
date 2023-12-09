package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SubActivity extends AppCompatActivity {

   public static MaterialToolbar SubMaterialToolbar;

    TextView uttor;
     public static String UTTOR1 = "";
    public static String TITLE = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        SubMaterialToolbar= findViewById(R.id.SubMaterialToolbar);
        uttor = findViewById(R.id.uttor);




        uttor.setText(UTTOR1);




        SubMaterialToolbar.setTitle(TITLE);



        SubMaterialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define your onclick behavior here
                // For example, you can go back to the previous screen
               startActivity(new Intent(SubActivity.this,ProshnoActivity.class));
               finish();

            }
        });



    }

    @Override
    public void onBackPressed() {
       // startActivity(new Intent(SubActivity.this,ProshnoActivity.class));
        finish();

    }
}