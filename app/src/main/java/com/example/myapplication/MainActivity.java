package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    final ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap = new HashMap<>();
    GridView gridView;


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

    private void loadData() {

        hashMap = new HashMap<>();
        hashMap.put("item_name", " স্বর্ণ ও রুপার বর্তমান বাজারদর");
        hashMap.put("item_pic", String.valueOf(R.drawable.money));
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("item_name", "যাকাত সম্পর্কিত কিছু জিজ্ঞাসা");
        hashMap.put("item_pic", String.valueOf(R.drawable.question));
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("item_name", "যাকাত সম্পর্কিত লেকচার ভিডিও");
        hashMap.put("item_pic", String.valueOf(R.drawable.video));
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("item_name", "যাকাত ক্যালকুলেটর");
        hashMap.put("item_pic", String.valueOf(R.drawable.budget));
        arrayList.add(hashMap);

    }


    //===============================================================
    //===============================================================

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(MainActivity.this, android.app.AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setIcon(R.drawable.baseline_warning_24).setTitle("সতর্কতা !").setMessage("আপনি কি বের হতে চান ?").setNegativeButton("না", (dialog, which) -> dialog.dismiss()).setPositiveButton("হ্যাঁ", (dialog, which) -> finish()).show();


    }

    private class MyAdapter extends BaseAdapter {


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

            LayoutInflater layoutInflater = getLayoutInflater();

            convertView = layoutInflater.inflate(R.layout.item, parent, false);

            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView = convertView.findViewById(R.id.textView);
            MaterialCardView materialCardView = convertView.findViewById(R.id.materialCardView);

            hashMap = arrayList.get(position);
            String NAME = hashMap.get("item_name");
            String item_pic = hashMap.get("item_pic");
            int pic = 0;
            if (item_pic != null) pic = Integer.parseInt(item_pic);


            textView.setText(NAME);
            imageView.setImageResource(pic);


            materialCardView.setOnClickListener(v -> {

                if (NAME != null) {
                    if (NAME.contains("্বর্ণ ও রুপার বর্তমান বাজারদর")) {
                        Intent intent = new Intent(MainActivity.this, ShornoActivity.class);
                        startActivity(intent);
                    } else if (NAME.contains("যাকাত সম্পর্কিত কিছু জিজ্ঞাসা")) {
                        Intent intent = new Intent(MainActivity.this, ProshnoActivity.class);
                        startActivity(intent);
                    } else if (NAME.contains("যাকাত সম্পর্কিত লেকচার ভিডিও")) {
                        startActivity(new Intent(MainActivity.this, LactureActivity.class));
                    } else {
                        Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                        startActivity(intent);
                    }
                }

            });
            return convertView;
        }
    }
}