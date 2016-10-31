package example.rick.denisyou;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import example.rick.tablayoutdemo.R;

public class MainAFL extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_afl);

        PagerTabStrip tabStrip = (PagerTabStrip) findViewById(R.id.pagetTab);
        tabStrip.setDrawFullUnderline(true);
        tabStrip.setTabIndicatorColorResource(android.R.color.holo_blue_dark);


        final List<View> views;

        ViewPager viewPager;
        viewPager = (ViewPager) findViewById(R.id.pager);
        LayoutInflater inflater = getLayoutInflater();
        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.layout1, null));
        views.add(inflater.inflate(R.layout.layout2, null));
        views.add(inflater.inflate(R.layout.layout3, null));

        final List<String> titleList;
        titleList = new ArrayList<String>();
        titleList.add("Tab1");
        titleList.add("Tab2");
        titleList.add("Tab3");

        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override  public boolean isViewFromObject(View arg0, Object arg1) {  // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override  public int getCount() {  // TODO Auto-generated method stub
                return views.size();
            }

            @Override  public void destroyItem(ViewGroup container, int position, Object object) {  // TODO Auto-generated method stub
                container.removeView(views.get(position));
            }

            @Override  public Object instantiateItem(ViewGroup container, int position) {  // TODO Auto-generated method stub
                container.addView(views.get(position));
                return views.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {  // TODO Auto-generated method stub
                return titleList.get(position);
            }

        };

        viewPager.setAdapter(pagerAdapter);
    }


}
