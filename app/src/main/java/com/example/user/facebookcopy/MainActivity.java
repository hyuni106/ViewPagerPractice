package com.example.user.facebookcopy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.user.facebookcopy.fragment.MessageFragment;
import com.example.user.facebookcopy.fragment.NewsFeedFragment;
import com.example.user.facebookcopy.fragment.SeeMoreFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager mainViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        mainViewPager.setAdapter(new MainActivity.MyViewPagerAdapter(getSupportFragmentManager()));
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
                return new MessageFragment();
            } else if (position == 2) {
                return new MessageFragment();
            } else if (position == 3) {
                return new MessageFragment();
            } else {
                return new SeeMoreFragment();
            }
        }
    }
}
