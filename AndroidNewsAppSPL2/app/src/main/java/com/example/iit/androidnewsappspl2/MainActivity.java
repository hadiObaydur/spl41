package com.example.iit.androidnewsappspl2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;

import com.example.iit.androidnewsappspl2.DetailArticle;
import com.example.iit.androidnewsappspl2.ItemCategoryList;
import com.example.iit.androidnewsappspl2.LanguageFragment;
import com.example.iit.androidnewsappspl2.R;
import com.example.iit.androidnewsappspl2.ThemeFragment;
import com.example.iit.androidnewsappspl2.WebViewFragment;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<String>arrayList=new ArrayList<String>();
    ArrayList<String>arrayListAll;
    ArrayList<String>arr;
    ArrayList<String>allSources=new ArrayList<String>();

    private ArrayList<String> mArray;
    private static final String PREFS_NAME = "prefs";
    private static final String PREF_DARK_THEME = "dark_theme";
    boolean useDarkTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        useDarkTheme = preferences.getBoolean(PREF_DARK_THEME, false);

        if(useDarkTheme) {
            setTheme(R.style.AppTheme_Dark_NoActionBar);
        }
        super.onCreate(savedInstanceState);
        arrayList=SingletonForUserInformation.getSingletonForUserInformation().getUserCategory();
        //arrayListAll=new ArrayList<String>();
       // arr=new ArrayList<String>();
        //mArray = new ArrayList<String>();

        allSources.add("bbc");
        allSources.add("abc");
        allSources.add("CNN");

        //mArray.add("Us");
       // mArray.add("arabic");


       /* arrayListAll.add("topStories");
        arrayListAll.add("entertainment");
        arrayListAll.add("business");
        arrayListAll.add("tech");
        arrayListAll.add("top");
        arrayListAll.add("health");
        arrayList.add("topStories"); //jodi account thake taile account theke load korbe naile default theke load korbe category
        arrayList.add("entertainment");
        arrayList.add("business");
        arrayList.add("sports");
        arrayList.add("technology");
        //arrayList.remove(4);
        for(String name : arrayList)
        {
            arr.add(name);
        }
        //arr=arrayList;
        //arrayList.clear();
        for(int i=0;i<arrayListAll.size();i++){
            if(!arr.contains(arrayListAll.get(i))){
                arr.add(arrayListAll.get(i));
            }
        }

        //arrayList.remove("top");
        //Toast.makeText(getApplicationContext(),"size"+arrayList.size(),Toast.LENGTH_LONG).show();
       */
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //categoryTitle=getPageTitle();
        for (int i = 0; i < arrayList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(arrayList.get(i)));
        }

        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(),arrayList,this);
        //tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(onTabSelectedListener(viewPager));
    }

    private TabLayout.OnTabSelectedListener onTabSelectedListener(final ViewPager pager) {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition(),true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                pager.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }



//    public void addCategory(String categoryName){
//        arrayList.add(categoryName);
//    }
//    public void deleteCategory(String categoryName){
//        arrayList.remove(categoryName);
//    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            Toast.makeText(getApplicationContext(),"AMI JAITeci",Toast.LENGTH_LONG).show();
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        if (id == R.id.headlinesection) {
            Intent detail = new Intent(getApplicationContext(),ItemCategoryList.class);
           // detail.putStringArrayListExtra("arrayListAll",arr);
           // detail.putExtra("count",arrayList.size());
            detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(detail);
        }

        if (id == R.id.prefer_sources) {
            Intent detail = new Intent(getApplicationContext(),YourWishesAboutSources.class);
            //detail.putStringArrayListExtra("allSources",allSources);
            //detail.putExtra("count",pre.size());
            detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(detail);
        }

        if (id == R.id.language) {
           // bundle.putStringArrayList("mArray",mArray);
            // bundle.putInt("count",arrayList.size());
            fragment = new LanguageFragment();
            //fragment.setArguments(bundle);
        }

        if(id == R.id.darktheme){
//            bundle.putBoolean("useDarkTheme",useDarkTheme);
//            fragment = new ThemeFragment();
//            fragment.setArguments(bundle);


            if(useDarkTheme==true){

                item.setTitle("use dark theme");
                useDarkTheme=false;
            }
            else
            {
                item.setTitle("use light theme");
                useDarkTheme=true;
            }

            SharedPreferences.Editor editor =getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
            editor.putBoolean(PREF_DARK_THEME, useDarkTheme);
            editor.apply();

            Intent intent = getIntent();
            finish();

            startActivity(intent);

        }
        if (id == R.id.fb) {
            /*
            bundle.putString("url", "https://www.facebook.com/androidhungerAH");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);*/
            Intent detail = new Intent(getApplicationContext(),DetailArticle.class);
            detail.putExtra("webURL","https://www.facebook.com/");
            detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(detail);
        } else if (id == R.id.gplus) {
            bundle.putString("url", "https://plus.google.com/");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        } else if (id == R.id.twitter) {
            bundle.putString("url", "https://www.twitter.com/");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        } else if (id == R.id.github) {
            bundle.putString("url", "https://github.com/hadiobaydur");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        } else if (id == R.id.youtube) {
            Intent detail = new Intent(getApplicationContext(),DetailArticle.class);
            detail.putExtra("webURL","https://www.youtube.com/");
            detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(detail);
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
