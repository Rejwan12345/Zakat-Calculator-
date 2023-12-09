package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    HashMap<String,String> hashMap = new HashMap<>();
    ArrayList <HashMap<String,String>> arrayList = new ArrayList<>();
    GridView gridView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         gridView = findViewById(R.id.gridView);

         loadData();

         MyAdapter myAdapter = new MyAdapter();
         gridView.setAdapter(myAdapter);



    }

    //===============================================================
    //===============================================================

    private class MyAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater  layoutInflater = getLayoutInflater();

            convertView = layoutInflater.inflate(R.layout.item , parent , false);

            ImageView  imageView = convertView.findViewById(R.id.imageView);
            TextView textView = convertView.findViewById(R.id.textView);
            MaterialCardView materialCardView = convertView.findViewById(R.id.materialCardView);

            hashMap = arrayList.get(position);
            String NAME = hashMap.get("item_name");
            int pic = Integer.parseInt(hashMap.get("item_pic"));



            textView.setText(NAME);
            imageView.setImageResource(pic);


            materialCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (NAME.contains("্বর্ণ ও রুপার বর্তমান বাজারদর")){

                        Intent intent = new Intent(MainActivity.this, ShornoActivity.class);
                        startActivity(intent);

                    }else if (NAME.contains("যাকাত সম্পর্কিত কিছু জিজ্ঞাসা")){

                        Intent intent = new Intent(MainActivity.this, ProshnoActivity.class);
                        startActivity(intent);
                    } else if (NAME.contains("যাকাত সম্পর্কিত লেকচার ভিডিও")) {

                       startActivity(new Intent(MainActivity.this,LactureActivity.class));

                    }else {
                        Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                        startActivity(intent);

                    }


                }
            });
            return  convertView;
        }
    }


    //===============================================================
    //===============================================================

    private void loadData() {

        hashMap = new HashMap<>();
        hashMap.put("item_name", " স্বর্ণ ও রুপার বর্তমান বাজারদর" );
        hashMap.put("item_pic", ""+R.drawable.money);
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("item_name", "যাকাত সম্পর্কিত কিছু জিজ্ঞাসা" );
        hashMap.put("item_pic", ""+R.drawable.question);
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("item_name", "যাকাত সম্পর্কিত লেকচার ভিডিও");
        hashMap.put("item_pic", ""+R.drawable.video);
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("item_name", "যাকাত ক্যালকুলেটর");
        hashMap.put("item_pic", ""+R.drawable.budget);
        arrayList.add(hashMap);

    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(MainActivity.this ,android.app.AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                .setIcon(R.drawable.baseline_warning_24)
                .setTitle("সতর্কতা !")
                .setMessage("আপনি কি বের হতে চান ?")
                .setNegativeButton("না", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .setPositiveButton("হ্যাঁ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();

                    }
                })
                .show();



    }
}