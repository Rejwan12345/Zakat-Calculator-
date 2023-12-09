package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.HashMap;

public class ProshnoActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;

    ListView listView;

    HashMap<String,String > hashMap = new HashMap<>();
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proshno);
        materialToolbar= findViewById(R.id.materialToolbar);

       listView=findViewById(R.id.listView);

       loadData();

       MY_ADAPTER myAdapter = new MY_ADAPTER();
       listView.setAdapter(myAdapter);


        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define your onclick behavior here
                // For example, you can go back to the previous screen
                startActivity(new Intent(ProshnoActivity.this,MainActivity.class));
                finish();
            }
        });



    }

    private class MY_ADAPTER extends BaseAdapter{


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
            convertView = layoutInflater.inflate(R.layout.list,parent,false);

            TextView textView = convertView.findViewById(R.id.textView);

            hashMap=arrayList.get(position);

            String PROSHNO = hashMap.get("proshno");

            textView.setText(PROSHNO);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (PROSHNO.contains("যাকাত কি ?")){

                        SubActivity.TITLE = "যাকাত কি ?";
                        SubActivity.UTTOR1= getResources().getString(R.string.যাকাতকি);
                        Intent intent = new Intent(ProshnoActivity.this, SubActivity.class);
                        startActivity(intent);

                    } else if (PROSHNO.contains("যাকাত ফরজ হওয়ার কারণ সমূহ কি ?")) {

                        SubActivity.TITLE = "যাকাত ফরজ হওয়ার কারণ সমূহ কি ?";
                        SubActivity.UTTOR1= getResources().getString(R.string.যাকাতফরজহওয়ারকারণসমূহকি);
                        Intent intent = new Intent(ProshnoActivity.this, SubActivity.class);
                        startActivity(intent);

                    } else if (PROSHNO.contains("যাকাত কাকে দেওয়া হয় ?")) {

                        SubActivity.TITLE = "যাকাত কাকে দেওয়া হয় ?";
                        SubActivity.UTTOR1= getResources().getString(R.string.যাকাতকাকেদেওয়াহয়);
                        Intent intent = new Intent(ProshnoActivity.this, SubActivity.class);
                        startActivity(intent);

                    } else if (PROSHNO.contains("কয় ধরণের সম্পদ যাকাতযোগ্য সম্পদ ?")) {

                        SubActivity.TITLE = "কয় ধরণের সম্পদ যাকাতযোগ্য সম্পদ ?";
                        SubActivity.UTTOR1= getResources().getString(R.string.কয়ধরণেরসম্পদযাকাতযোগ্যসম্পদ);
                        Intent intent = new Intent(ProshnoActivity.this, SubActivity.class);
                        startActivity(intent);

                    } else if (PROSHNO.contains("যাকাত সম্পর্কে কুরআনে কি বলা আছে ?")) {

                        SubActivity.TITLE = "যাকাত সম্পর্কে কুরআনে কি বলা আছে ?";
                        SubActivity.UTTOR1= getResources().getString(R.string.যাকাতসম্পর্কেকুরআনেকিবলাআছে);
                        Intent intent = new Intent(ProshnoActivity.this, SubActivity.class);
                        startActivity(intent);

                    } else if (PROSHNO.contains("যাকাত সম্পর্কে হাদিসে কি বলা আছে ?")) {

                        SubActivity.TITLE = "যাকাত সম্পর্কে হাদিসে কি বলা আছে ?";
                        SubActivity.UTTOR1= getResources().getString(R.string.যাকাতসম্পর্কেহাদিসেকিবলাআছে);
                        Intent intent = new Intent(ProshnoActivity.this, SubActivity.class);
                        startActivity(intent);

                    }else {

                        SubActivity.TITLE = "যাকাত আদায় করলে আপনার কি লাভ ?";
                        SubActivity.UTTOR1= getResources().getString(R.string.যাকাতআদায়করলেআপনারকিলাভ);
                        Intent intent = new Intent(ProshnoActivity.this, SubActivity.class);
                        startActivity(intent);


                    }





                }
            });



            Animation animation = AnimationUtils.loadAnimation(ProshnoActivity.this, R.anim.demo);
            convertView.startAnimation(animation); // 'view' is the root view of your ListView item



            return convertView;
        }
    }

    private void loadData(){

        hashMap = new HashMap<>();
        hashMap.put("proshno","যাকাত কি ?");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("proshno","যাকাত ফরজ হওয়ার কারণ সমূহ কি ?");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("proshno","যাকাত কাকে দেওয়া হয় ?");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("proshno","কয় ধরণের সম্পদ যাকাতযোগ্য সম্পদ ?");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("proshno","যাকাত সম্পর্কে কুরআনে কি বলা আছে ?");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("proshno","যাকাত সম্পর্কে হাদিসে কি বলা আছে ?");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("proshno","যাকাত আদায় করলে আপনার কি লাভ ?");
        arrayList.add(hashMap);



    }

    @Override
    public void onBackPressed() {
       // startActivity(new Intent(ProshnoActivity.this,MainActivity.class));
        finish();
    }
}