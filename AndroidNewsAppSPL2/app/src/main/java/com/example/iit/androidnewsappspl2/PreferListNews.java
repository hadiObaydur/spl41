package com.example.iit.androidnewsappspl2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.github.florent37.diagonallayout.DiagonalLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import com.example.iit.androidnewsappspl2.Adapter.ListNewsAdapter;
import com.example.iit.androidnewsappspl2.Common.Common;
import com.example.iit.androidnewsappspl2.Interface.NewsService;
import com.example.iit.androidnewsappspl2.Model.Article;
import com.example.iit.androidnewsappspl2.Model.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreferListNews extends AppCompatActivity {

    KenBurnsView kbv;
    DiagonalLayout diagonalLayout;
    AlertDialog dialog;
    NewsService mService;
    TextView top_author,top_title;
    SwipeRefreshLayout swipeRefreshLayout;

    String source="",sortBy="",webHotURL="";

    ListNewsAdapter adapter;
    RecyclerView lstNews;
    RecyclerView.LayoutManager layoutManager;

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
        setContentView(R.layout.activity_prefer_list_news);


        //Service
        mService = Common.getNewsService();

        dialog = new SpotsDialog(this);

        //View
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefresh1);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadNews(source,true);
            }
        });

        diagonalLayout = (DiagonalLayout)findViewById(R.id.diagonalLayout);
        diagonalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(getBaseContext(),DetailArticle.class);
                detail.putExtra("webURL",webHotURL);
                startActivity(detail);
            }
        });
        kbv = (KenBurnsView)findViewById(R.id.top_image);
        top_author = (TextView)findViewById(R.id.top_author);
        top_title = (TextView)findViewById(R.id.top_title);

        lstNews = (RecyclerView)findViewById(R.id.lstNews);
        lstNews.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        lstNews.setLayoutManager(layoutManager);

        //Intent
        if(getIntent() != null)
        {
            source = getIntent().getStringExtra("source");
            if(!source.isEmpty())
            {
                loadNews(source,false);
            }
        }
    }

    private void loadNews(String source, boolean isRefreshed) {
        if(!isRefreshed)
        {
            dialog.show();
            mService.getNewestArticles(Common.getAPIUrl(source,sortBy,Common.API_KEY))
                    .enqueue(new Callback<News>() {
                        @Override
                        public void onResponse(Call<News> call, Response<News> response) {
                            dialog.dismiss();
                            //Get first article
                            Picasso.with(getBaseContext())
                                    .load(response.body().getArticles().get(0).getUrlToImage())
                                    .into(kbv);

                            top_title.setText(response.body().getArticles().get(0).getTitle());

                            top_author.setText(response.body().getArticles().get(0).getAuthor());

                            webHotURL = response.body().getArticles().get(0).getUrl();

                            //Load remain articles
                            List<Article> removeFristItem = response.body().getArticles();
                            //Because we already load first item to show on Diagonal Layout
                            //So we need remove it
                            removeFristItem.remove(0);
                            adapter = new ListNewsAdapter(removeFristItem,getBaseContext());
                            adapter.notifyDataSetChanged();
                            lstNews.setAdapter(adapter);

                        }

                        @Override
                        public void onFailure(Call<News> call, Throwable t) {

                        }
                    });
        }
        else
        {
            dialog.show();
            mService.getNewestArticles(Common.getAPIUrl(source,sortBy,Common.API_KEY))
                    .enqueue(new Callback<News>() {
                        @Override
                        public void onResponse(Call<News> call, Response<News> response) {
                            dialog.dismiss();
                            //Get first article
                            Picasso.with(getBaseContext())
                                    .load(response.body().getArticles().get(0).getUrlToImage())
                                    .into(kbv);

                            top_title.setText(response.body().getArticles().get(0).getTitle());
                            top_author.setText(response.body().getArticles().get(0).getAuthor());

                            webHotURL = response.body().getArticles().get(0).getUrl();

                            //Load remain articles
                            List<Article> removeFristItem = response.body().getArticles();
                            //Because we already load first item to show on Diagonal Layout
                            //So we need remove it
                            removeFristItem.remove(0);
                            adapter = new ListNewsAdapter(removeFristItem,getBaseContext());
                            adapter.notifyDataSetChanged();
                            lstNews.setAdapter(adapter);

                        }

                        @Override
                        public void onFailure(Call<News> call, Throwable t) {

                        }
                    });
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}
