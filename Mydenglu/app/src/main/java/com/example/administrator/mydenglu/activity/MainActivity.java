package com.example.administrator.mydenglu.activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.administrator.mydenglu.R;
import com.example.administrator.mydenglu.fragment.DengLu;
import com.example.administrator.mydenglu.fragment.ZhuChe;


public class MainActivity extends AppCompatActivity {

    Fragment[] mfragment = new Fragment[2];
    LinearLayout ll0,ll1;
    mainactivity_fill mfill;
    ViewPager vp_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp_activity= (ViewPager) findViewById(R.id.vp_activity);
        ll0= (LinearLayout) findViewById(R.id.ll0);
        ll1= (LinearLayout) findViewById(R.id.ll1);
        mfragment[0] = new DengLu();
        mfragment[1] = new ZhuChe();
        ll0.setAlpha(1f);
        ll1.setAlpha(0.5f);
        //fragment的填充
        FragmentManager manager = getSupportFragmentManager();
        mfill = new mainactivity_fill(manager);
        vp_activity.setAdapter(mfill);
        //viewpager的监听事件
        vp_activity.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //当滑动到那页是
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        ll0.setAlpha(1f);
                        ll1.setAlpha(0.5f);
                        break;
                    case 1:
                        ll0.setAlpha(0.5f);
                        ll1.setAlpha(1f);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //viewpager的填充器
    public class mainactivity_fill extends FragmentPagerAdapter {


        public mainactivity_fill(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mfragment[position];
        }

        @Override
        public int getCount() {
            return mfragment.length;
        }
    }
}
