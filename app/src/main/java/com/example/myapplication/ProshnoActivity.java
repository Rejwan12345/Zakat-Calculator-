package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.HashMap;

public class ProshnoActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;

    ListView listView;

    HashMap<String, String> hashMap = new HashMap<>();
    final ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proshno);
        materialToolbar = findViewById(R.id.materialToolbar);

        listView = findViewById(R.id.listView);

        loadData();

        MY_ADAPTER myAdapter = new MY_ADAPTER();
        listView.setAdapter(myAdapter);


        materialToolbar.setNavigationOnClickListener(v -> finish());


    }

    private void loadData() {

        hashMap = new HashMap<>();
        hashMap.put("proshno", "যাকাত কি ?");
        hashMap.put("uttor", getString(R.string.যাকাতকি));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("proshno", "যাকাত ফরজ হওয়ার কারণ সমূহ কি ?");
        hashMap.put("uttor", getString(R.string.যাকাতফরজহওয়ারকারণসমূহকি));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("proshno", "যাকাত কাকে দেওয়া হয় ?");
        hashMap.put("uttor", getString(R.string.যাকাতকাকেদেওয়াহয়));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("proshno", "কয় ধরণের সম্পদ যাকাতযোগ্য সম্পদ ?");
        hashMap.put("uttor", getString(R.string.কয়ধরণেরসম্পদযাকাতযোগ্যসম্পদ));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("proshno", "যাকাত সম্পর্কে কুরআনে কি বলা আছে ?");
        hashMap.put("uttor", getString(R.string.যাকাতসম্পর্কেকুরআনেকিবলাআছে));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("proshno", "যাকাত সম্পর্কে হাদিসে কি বলা আছে ?");
        hashMap.put("uttor", getString(R.string.যাকাতসম্পর্কেহাদিসেকিবলাআছে));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("proshno", "যাকাত আদায় করলে আপনার কি লাভ ?");
        hashMap.put("uttor", getString(R.string.যাকাতআদায়করলেআপনারকিলাভ));
        arrayList.add(hashMap);


    }

    @Override
    public void onBackPressed() {
        // startActivity(new Intent(ProshnoActivity.this,MainActivity.class));
        finish();
    }

    private class MY_ADAPTER extends BaseAdapter {


        final Animation animation = AnimationUtils.loadAnimation(ProshnoActivity.this, R.anim.demo);

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
            convertView = layoutInflater.inflate(R.layout.list, parent, false);

            TextView textView = convertView.findViewById(R.id.textView);

            hashMap = arrayList.get(position);

            String PROSHNO = hashMap.get("proshno");
            String UTTOR = hashMap.get("uttor");

            textView.setText(PROSHNO);

            textView.setOnClickListener(v -> {

                SubActivity.TITLE = PROSHNO;
                SubActivity.UTTOR1 = UTTOR;
                Intent intent = new Intent(ProshnoActivity.this, SubActivity.class);
                startActivity(intent);


            });
            convertView.startAnimation(animation); // 'view' is the root view of your ListView item


            return convertView;
        }
    }
}