package com.deneme.hekotech.proje1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;

public class tanitim extends Activity {

    private ViewPager viewPager;
    private Button ileri;
    private Button geri;
    private VViewPagerAdapter viewPagerAdapter;

    saveRead sr;
    private TextView mTextMessage;


    private int[] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        sr = new saveRead(this);
        if(!sr.isFirst()) {

            Intent i = new Intent(tanitim.this, MainActivity.class);
            startActivity(i);
            finish();

        }

        setContentView(R.layout.activity_tanitim);

        viewPager = findViewById(R.id.vPager);

        layouts = new int[]{R.layout.intro1,R.layout.intro2,R.layout.intro3,R.layout.intro4,R.layout.intro5};

        viewPagerAdapter = new VViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);


        viewPager.addOnPageChangeListener(viewListener);


    }

    private int getItem(int i){
        return viewPager.getCurrentItem() + i;
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if(position==layouts.length-1){
                sr.savedata("isfirst",false);
                Intent i = new Intent(tanitim.this,MainActivity.class);
                startActivity(i);

            }
            else{
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public class VViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;


        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(layouts[position],container,false);
            container.addView(v);
            return v;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = (View)object;
            container.removeView(v);
        }
    }

}
