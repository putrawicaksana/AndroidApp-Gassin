package com.example.gasssinapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

public class Pop extends Activity {

    public static final String EXTRA_URL = "imgurl";
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_SHORTDESC = "shortdesc";
    public static final String EXTRA_USER = "user";
    public static final String EXTRA_PLATFORM = "platform";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width =dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.8));

        Intent intent = getIntent();
        String imageurl= intent.getStringExtra(EXTRA_URL);
        String title = intent.getStringExtra(EXTRA_TITLE);
        String shortdesc = intent.getStringExtra(EXTRA_SHORTDESC);
        String user = intent.getStringExtra(EXTRA_USER);
        String platform = intent.getStringExtra(EXTRA_PLATFORM);

        ImageView imagepop = findViewById(R.id.imagePop);
        TextView titlepop = findViewById(R.id.textViewTitlePop);
        TextView shortdescpop = findViewById(R.id.textViewShortDescPop);
        TextView userpop = findViewById(R.id.textViewRatingPop);
        TextView platformpop = findViewById(R.id.textViewPricePop);

        Glide.with(this).load(imageurl).into(imagepop);
        titlepop.setText(title);
        shortdescpop.setText(shortdesc);
        userpop.setText(user);
        platformpop.setText(platform);

    }
}
