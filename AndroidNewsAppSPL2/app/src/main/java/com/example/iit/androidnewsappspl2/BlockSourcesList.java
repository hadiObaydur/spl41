package com.example.iit.androidnewsappspl2;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


import java.util.ArrayList;


public class BlockSourcesList extends AppCompatActivity {

    RecyclerView listItem;
    RecyclerView.LayoutManager layoutManager;

    ListBlockSourcesAdapter adapter;

    ArrayList<String>allSources=new ArrayList<String>();
    ArrayList<String> blockSources=new ArrayList<String>();
    private int count;

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
        setContentView(R.layout.block_sources);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Service


        //View
       // blockSources.add("abc");
       // allSources=getIntent().getStringArrayListExtra("allSources");
        //count=getIntent().getIntExtra("count",1);
        allSources=SingletonForUserInformation.getSingletonForUserInformation().getAllSources();
        blockSources=SingletonForUserInformation.getSingletonForUserInformation().getBlockSourcesForAdapter();
        count=blockSources.size();
      //  Toast.makeText(this,""+count,Toast.LENGTH_LONG).show();
        listItem= (RecyclerView)findViewById(R.id.list_source);
        listItem.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        listItem.setLayoutManager(layoutManager);
        adapter = new ListBlockSourcesAdapter(this,allSources,blockSources);
        adapter.notifyDataSetChanged();
        listItem.setAdapter(adapter);
        listItem.setItemAnimator(new DefaultItemAnimator());
        //Intent

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
