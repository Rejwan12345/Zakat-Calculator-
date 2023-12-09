package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class LactureActivity extends AppCompatActivity implements NetworkStateReceiver.NetworkStateReceiverListener
{

    private NetworkStateReceiver networkStateReceiver;

    LottieAnimationView check ;

    MaterialToolbar  materialToolbar;


    ListView listView;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String>hashMap=new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lacture);

        materialToolbar = findViewById(R.id.materialToolbar);
        check=findViewById(R.id.check);
        listView= findViewById(R.id.listView);


        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define your onclick behavior here
                // For example, you can go back to the previous screen
                startActivity(new Intent(LactureActivity.this,MainActivity.class));
                finish();
            }
        });

        startNetworkBroadcastReceiver(LactureActivity.this);

    }

    @Override
    protected void onPause() {
        unregisterNetworkBroadcastReceiver(LactureActivity.this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        registerNetworkBroadcastReceiver(LactureActivity.this);
        super.onResume();
    }

    @Override
    public void networkAvailable() {


        loadData();
        MY_ADAPTER  myAdapter = new MY_ADAPTER();
        listView.setAdapter(myAdapter);
        check.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);

    }

    @Override
    public void networkUnavailable() {

        listView.setVisibility(View.GONE);
        check.setVisibility(View.VISIBLE);
        Toast.makeText(LactureActivity.this, "no internet connection", Toast.LENGTH_SHORT).show();
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

    //===================================================================================

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

            LayoutInflater  layoutInflater = getLayoutInflater();

            convertView = layoutInflater.inflate(R.layout.youtube,parent,false);

            ImageView video_thumbnail = convertView.findViewById(R.id.video_thumbnail);
            TextView video_title = convertView.findViewById(R.id.video_title);
            TextView video_description = convertView.findViewById(R.id.video_description);
            MaterialCardView materialCardView = convertView.findViewById(R.id.materialCardView);

            hashMap = arrayList.get(position);
            String title = hashMap.get("title");
            String des = hashMap.get("des");
            String img_link = hashMap.get("img_link");

            String embeded_link = hashMap.get("embed");

            String url = "https://img.youtube.com/vi/"+img_link+"/0.jpg ";

            video_title.setText(title);
            video_description.setText(des);

            Picasso.get().load(url).into(video_thumbnail);

            materialCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   if (embeded_link.contains("https://www.youtube.com/embed/EuLxcIDGaUc")) {

                       Tube_play.URL = embeded_link;
                       Intent intent = new Intent(LactureActivity.this, Tube_play.class);
                       startActivity(intent);


                   } else if (embeded_link.contains("https://www.youtube.com/embed/utuvy32b7BM")) {

                       Tube_play.URL = embeded_link;
                       Intent intent = new Intent(LactureActivity.this, Tube_play.class);
                       startActivity(intent);


                   } else if (embeded_link.contains("https://www.youtube.com/embed/TCBixQ8p7nU")) {

                       Tube_play.URL = embeded_link;
                       Intent intent = new Intent(LactureActivity.this, Tube_play.class);
                       startActivity(intent);

                   } else if (embeded_link.contains("https://www.youtube.com/embed/7QLWNnpKkqM")) {

                       Tube_play.URL = embeded_link;
                       Intent intent = new Intent(LactureActivity.this, Tube_play.class);
                       startActivity(intent);

                   } else if (embeded_link.contains("https://www.youtube.com/embed/fvNAYs0LFqg")) {

                       Tube_play.URL = embeded_link;
                       Intent intent = new Intent(LactureActivity.this, Tube_play.class);
                       startActivity(intent);

                   } else if (embeded_link.contains("https://www.youtube.com/embed/FxbjRYIgXOo")) {

                       Tube_play.URL = embeded_link;
                       Intent intent = new Intent(LactureActivity.this, Tube_play.class);
                       startActivity(intent);

                   }else {

                       Tube_play.URL = embeded_link;
                       Intent intent = new Intent(LactureActivity.this, Tube_play.class);
                       startActivity(intent);

                   }


                }
            });

            return convertView;
        }
    }

    //=================================================================================

    private void loadData(){

        hashMap = new HashMap<>();
        hashMap.put("title","যাকাত || যাকাত দেওয়ার নিয়ম - Sheikh Ahmadullah || Shaikh Ahmadullah Waz 2021");
        hashMap.put("des","প্রিয় দর্শক নিয়মিত ইসলামিক ভিডিও পেতে আমাদের চ্যানেলটি সাবস্ক্রাইব করে সাথেই থাকুন.");
        hashMap.put("embed","https://www.youtube.com/embed/EuLxcIDGaUc");
        hashMap.put("img_link","EuLxcIDGaUc");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title","সোনা এবং রুপার নিসাব পরিমান কতটুকু জেনে নিন | যাকাতের সম্পদ | mizanur rahman azhari");
        hashMap.put("des","যাকাত ফরজ হওয়ার শর্ত নিয়ে অালোচনা করলেন মিজানুর রহমান অাজহারী। ইসলাম প্রচারের সার্থে ভিডিও টি শেয়ার করুন। best islamic lecturer mijanur rahman azhari ❤ অামাদের সাথে থাকার জন্য ধন্যবাদ ❤");
        hashMap.put("embed","https://www.youtube.com/embed/utuvy32b7BM");
        hashMap.put("img_link","utuvy32b7BM");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("title","যাকাত কাদের উপর ফরজ? যাকাত যাদেরকে দিবেন? যেভাবে দিবেন? যাকাত দেওয়ার উপায়। (আহমদউল্লাহ মাদানী)\u200B\n" +
                "\n" +
                "\u200B");
        hashMap.put("des","পরকালে জাহান্নাম থেকে মুক্তি পেতে নামায পড়ুন, সৎ পথে চলুন। আমাদের ভিডিওগুলো দেখে মন্তব্য করতে ভুলবেননা। মনোযোগ সহকারে পুরোটা ভিডিও দেখুন");
        hashMap.put("embed","https://www.youtube.com/embed/TCBixQ8p7nU");
        hashMap.put("img_link","TCBixQ8p7nU");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("title","যাকাত কখন ফরজ হয় ও যাকাত কার উপর ফরজ হয় ||জাকাত ফরজ হওয়ার শর্ত সমূহ কি||zakat");
        hashMap.put("des","যাকাত কখন ফরজ হয় ও যাকাত কার উপর ফরজ হয় ||জাকাত ফরজ হওয়ার শর্ত সমূহ কি? ‘জাকাত’ ইসলামের মূল পাঁচ স্তম্ভের একটি। জাকাত অস্বীকারকারি নিঃসন্দেহে কাফির। বান্দার বৈধ উপার্জন থেকে একটি ‘নির্দিষ্ট পরিমাণ’ আল্লাহর নির্দেশিত পথে ব্যয় করার নাম ‘জাকাত’।নিসাব পরিমাণ সম্পদের মালিক সকল মুসলিম নর-নারীর উপর যাকাত প্রদান করা ফরজ। কোনো ব্যক্তি নিসাব পরিমাণ সম্পদের মালিক হওয়ার পর চাঁদের হিসাবে পরিপূর্ণ এক বছর অতিবাহিত হলে তার উপর পূর্ববর্তী বছরের যাকাত প্রদান করা ফরজ।");
        hashMap.put("embed","https://www.youtube.com/embed/7QLWNnpKkqM");
        hashMap.put("img_link","7QLWNnpKkqM");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("title","যাকাত কাকে দেয়া যাবে | Jakat kake deya jabe | Jakat kivabe dibo mizanur rahman azhari");
        hashMap.put("des","Mizanur rahman azhari Jakat waz | Jakat Kake deya jabe");
        hashMap.put("embed","https://www.youtube.com/embed/fvNAYs0LFqg");
        hashMap.put("img_link","fvNAYs0LFqg");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("title","যাকাত কাদের দেওয়া যাবে না? মিজানুর রহমান আজহারী ॥ (Zakat Kader Deya Jabe Na)~ Mizanur Rahman Azhari");
        hashMap.put("des","প্রবিষয়: কাদেরকে যাকাত দেওয়া যাবে না? বক্তাঃ মিজানুর রহমান আজহারী।এই ভিডিওটিতে আমরা মিজানুর রহমান আজহারীর মুখে বিস্তারিত জানব যে কোন কোন খাতে যাকাত দেওয়া যাবে না বা কাদেরকে যাকাত দেওয়া যাবে না। ");
        hashMap.put("embed","https://www.youtube.com/embed/FxbjRYIgXOo");
        hashMap.put("img_link","FxbjRYIgXOo");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("title","যাকাত না দিলে কি শাস্থি হবে শুনুন | শায়খ আহমাদুল্লাহ | Sheikh Ahmadullah new waz");
        hashMap.put("des","Voice of True tv কোন ধরনের দেশ বিরুধী কর্মকান্ড, সন্ত্রাসবাদ, জঙ্গি বাদ সমর্থন করে না, Voice of True tv এর সাথে থাকার জন্য সবাইকে ধন্যবাদ।");
        hashMap.put("embed","https://www.youtube.com/embed/yDS9p4fuxi0");
        hashMap.put("img_link","yDS9p4fuxi0");
        arrayList.add(hashMap);


    }


    @Override
    public void onBackPressed() {
       // startActivity(new Intent(LactureActivity.this,MainActivity.class));
        finish();
    }
}