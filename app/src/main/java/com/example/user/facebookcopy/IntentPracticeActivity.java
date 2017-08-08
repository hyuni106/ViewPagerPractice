package com.example.user.facebookcopy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IntentPracticeActivity extends AppCompatActivity {

    private android.widget.Button dialBtn;
    private Button callBtn;
    private Button internetBtn;
    private Button mapBtn;
    private Button emailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_practice);
        bindViews();
        setupEvents();
    }

    void setupEvents() {
        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:010-9991-8387"));
                startActivity(intent);
            }
        });

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:010-9991-8387"));
                startActivity(intent);
            }
        });

        internetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.naver.com"));
                startActivity(intent);
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:37.584526, 126.986116"));
                startActivity(intent);
            }
        });

        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:suhyun4.park@gmail.com"));
                startActivity(intent);
            }
        });
    }

    void bindViews() {
        this.emailBtn = (Button) findViewById(R.id.emailBtn);
        this.mapBtn = (Button) findViewById(R.id.mapBtn);
        this.internetBtn = (Button) findViewById(R.id.internetBtn);
        this.callBtn = (Button) findViewById(R.id.callBtn);
        this.dialBtn = (Button) findViewById(R.id.dialBtn);
    }
}
