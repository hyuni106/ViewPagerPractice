package com.example.user.facebookcopy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.facebookcopy.fragment.FriendsFragment;
import com.example.user.facebookcopy.fragment.MessageFragment;
import com.example.user.facebookcopy.fragment.NewsFeedFragment;
import com.example.user.facebookcopy.fragment.NotificationFragment;
import com.example.user.facebookcopy.fragment.SeeMoreFragment;
import com.example.user.facebookcopy.util.GlobalDatas;

public class MainActivity extends AppCompatActivity {
    private ViewPager mainViewPager;
    private android.widget.LinearLayout newsfeedLayout;
    private android.widget.LinearLayout friendRequestLayout;
    private android.widget.LinearLayout messageBtnLayout;
    private android.widget.LinearLayout notificationBtnLayout;
    private android.widget.LinearLayout seeMoreBtnLayout;
    private android.widget.TextView titleTxt;
    private LinearLayout newsfeedBtnLayout;
    private LinearLayout statusLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();
    }

    private void setValues() {
        GlobalDatas.initDatas();
        mainViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
    }

    private void setupEvents() {
        View.OnClickListener pageChangeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pageNum = Integer.parseInt(v.getTag().toString());
                mainViewPager.setCurrentItem(pageNum);
            }
        };

        newsfeedLayout.setOnClickListener(pageChangeListener);
        friendRequestLayout.setOnClickListener(pageChangeListener);
        messageBtnLayout.setOnClickListener(pageChangeListener);
        notificationBtnLayout.setOnClickListener(pageChangeListener);
        seeMoreBtnLayout.setOnClickListener(pageChangeListener);

        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    titleTxt.setText("뉴스피드");
                } else if (position == 1) {
                    titleTxt.setText("요청");
                } else if (position == 2) {
                    titleTxt.setText("메시지");
                } else if (position == 3) {
                    titleTxt.setText("알림");
                } else {
                    titleTxt.setText("더보기");
                }

                if (position == 0) {
                    newsfeedBtnLayout.setVisibility(View.VISIBLE);
                } else {
                    newsfeedBtnLayout.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        statusLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditStatusActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bindViews() {
        statusLayout = (LinearLayout)findViewById(R.id.statusLayout);
        this.seeMoreBtnLayout = (LinearLayout) findViewById(R.id.seeMoreBtnLayout);
        this.notificationBtnLayout = (LinearLayout) findViewById(R.id.notificationBtnLayout);
        this.messageBtnLayout = (LinearLayout) findViewById(R.id.messageBtnLayout);
        this.friendRequestLayout = (LinearLayout) findViewById(R.id.friendRequestLayout);
        this.newsfeedLayout = (LinearLayout) findViewById(R.id.newsfeedLayout);
        this.mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        this.newsfeedBtnLayout = (LinearLayout) findViewById(R.id.newsfeedBtnLayout);
        this.titleTxt = (TextView) findViewById(R.id.titleTxt);
    }

    class MyViewPagerAdapter extends FragmentStatePagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0) {
                return new NewsFeedFragment();
            } else if (position== 1){
                return new FriendsFragment();
            } else if (position == 2) {
                return new MessageFragment();
            } else if (position == 3) {
                return new NotificationFragment();
            } else {
                return new SeeMoreFragment();
            }
        }
    }
}
