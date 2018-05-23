package com.example.iit.androidnewsappspl2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.example.iit.androidnewsappspl2.ListCategoryAdapterForItemList;
import com.example.iit.androidnewsappspl2.R;

import java.util.ArrayList;


public class ItemCategoryList extends AppCompatActivity {

    RecyclerView listItem;
    RecyclerView.LayoutManager layoutManager;

    ListCategoryAdapterForItemList adapter;


    ArrayList<String> arrayListAll=new ArrayList<String>();
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
        setContentView(R.layout.category_delete_and_add_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Service


        //View
        //arrayListAll=getIntent().getStringArrayListExtra("arrayListAll");
        //count=getIntent().getIntExtra("count",1);
        arrayListAll=SingletonForUserInformation.getSingletonForUserInformation().getAllCategories();
        count=SingletonForUserInformation.getSingletonForUserInformation().getCountOfUserCategory();
        listItem= (RecyclerView)findViewById(R.id.list_source);
        listItem.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        listItem.setLayoutManager(layoutManager);
        adapter = new ListCategoryAdapterForItemList(this,arrayListAll,count);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getBaseContext(),MainActivity.class);
        finish();

        startActivity(intent);

    }
}
