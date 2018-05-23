package com.example.iit.androidnewsappspl2;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import dmax.dialog.SpotsDialog;

public class DetailArticle extends AppCompatActivity {

    WebView webView;
    AlertDialog dialog;
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
        setContentView(R.layout.activity_detail_article);

        dialog = new SpotsDialog(this);
        dialog.show();
        //WebView
        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient(){

            //press Ctrl+O

            @Override
            public void onPageFinished(WebView view, String url) {
                dialog.dismiss();
            }
        });

        if(getIntent() != null)
        {
            if(!getIntent().getStringExtra("webURL").isEmpty())
                webView.loadUrl(getIntent().getStringExtra("webURL"));
        }
    }
}
