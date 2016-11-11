package example.rick.tablayoutdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Tabtest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabtest);

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.ttb);
        setSupportActionBar(toolbar);

        toolbar.setTitle("課程一覽");
        toolbar.setTitleTextColor(0xFFFFFFFF);

        // tab
        android.support.design.widget.TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);

        //TabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        // nav
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.dltest);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        TextView navTV = (TextView) findViewById(R.id.nav_title);
        navTV.setText("學生姓名");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


           @SuppressWarnings("StatementWithEmptyBody")
           @Override
           public boolean onNavigationItemSelected(MenuItem item) {
               // Handle navigation view item clicks here.
               int id = item.getItemId();

               if (id == R.id.nav_camera) {
                   drawer.closeDrawer(GravityCompat.START);
                   return true;
               } else if (id == R.id.nav_gallery) {
                   drawer.closeDrawer(GravityCompat.START);
                   return true;
               } else if (id == R.id.nav_slideshow) {
                   drawer.closeDrawer(GravityCompat.START);
                   return true;
               } else if (id == R.id.nav_manage) {
                   drawer.closeDrawer(GravityCompat.START);
                   return true;
               } else if (id == R.id.nav_share) {
                   drawer.closeDrawer(GravityCompat.START);
                   return true;
               } else if (id == R.id.nav_send) {
                   drawer.closeDrawer(GravityCompat.START);
                   return true;
               }

           return false;
           }
       });



        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle( this, drawer, toolbar, R.string.navigation_drawer_open , R.string.navigation_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super .onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super .onDrawerOpened(drawerView);
            }
        };

        drawer.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.dltest);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fortestpage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, CoursePost.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}


