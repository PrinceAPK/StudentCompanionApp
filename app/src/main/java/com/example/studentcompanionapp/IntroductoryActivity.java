package com.example.studentcompanionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class IntroductoryActivity extends AppCompatActivity {

    ImageView logo, splashImage;
    TextView appName;
    LottieAnimationView lottieAnimationView;

    private static final int PAGE_NUM = 3;
    private ViewPager viewPager;
    private screenSlidePagerAdapter pagerAdapter;

    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);


        logo = findViewById(R.id.logoImage);
        splashImage = findViewById(R.id.introImage);
        appName = findViewById(R.id.appName);
        lottieAnimationView = findViewById(R.id.lottieAnimation);

        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new screenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        animation = AnimationUtils.loadAnimation(this, R.anim.s_c_anim);
        viewPager.startAnimation(animation);

        splashImage.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

    }


    private static class screenSlidePagerAdapter extends FragmentStatePagerAdapter{

        public screenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    OnboardingFragment1 tab1 = new OnboardingFragment1();
                    return tab1;
                case 1:
                    OnboardingFragment2 tab2 = new OnboardingFragment2();
                    return tab2;
                case 2:
                    OnboardingFragment3 tab3 = new OnboardingFragment3();
                    return tab3;

            }
            return null;
        }

        @Override
        public int getCount() {
            return PAGE_NUM;
        }
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();

    }
}