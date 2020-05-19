package com.example.gasssinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Beranda extends AppCompatActivity
{
    private Animation topAnim;
    private ImageView gassinshots, sample1;
    private ImageButton profile;
    private TextView sloganshots;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        //animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);

        //declare
        gassinshots = findViewById(R.id.gassinshot);
        sample1 = findViewById(R.id.sample1);
        sloganshots = findViewById(R.id.sloganshot);
        profile = findViewById(R.id.profile);

        gassinshots.setAnimation(topAnim);
        sample1.setAnimation(topAnim);
        sloganshots.setAnimation(topAnim);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent4 = new Intent(Beranda.this, Profile.class);
                startActivity(intent4);
            }
        });
    }
}
