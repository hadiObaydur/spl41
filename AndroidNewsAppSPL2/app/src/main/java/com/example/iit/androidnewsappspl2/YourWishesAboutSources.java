package com.example.iit.androidnewsappspl2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.example.iit.androidnewsappspl2.ListCategoryAdapterForItemList;
import com.example.iit.androidnewsappspl2.R;

import java.util.ArrayList;


public class YourWishesAboutSources extends AppCompatActivity implements  View.OnClickListener {

    ArrayList<String>allSources=new ArrayList<String>();

    View addSource,blocSource;
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
        setContentView(R.layout.your_wish_about_sources);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Service


        //View
        //allSources=getIntent().getStringArrayListExtra("allSources");
       // count=getIntent().getIntExtra("count",1);

        //Intent


        addSource= (View)findViewById(R.id.add);
        blocSource= (View)findViewById(R.id.block);

        addSource.setOnClickListener(this);
        blocSource.setOnClickListener(this);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getBaseContext(),MainActivity.class);
        finish();

        startActivity(intent);

    }



    @Override
    public void onClick(View view) {

        switch ((view.getId())) {
            case R.id.add:
                Intent detail = new Intent(getApplicationContext(), PreferSourcesList.class);
                //detail.putStringArrayListExtra("allSources", allSources);
                //detail.putExtra("count",pre.size());
                detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(detail);
                break;
            case R.id.block:

                Intent detail1 = new Intent(getApplicationContext(), BlockSourcesList.class);
                //detail1.putStringArrayListExtra("allSources", allSources);
                //detail.putExtra("count",pre.size());
                detail1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(detail1);
                break;
        }
    }
}
